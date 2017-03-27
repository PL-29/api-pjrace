package fr.solocal.dao.impl;

import fr.solocal.dao.ChallengeDAO;
import fr.solocal.dao.UserDAO;
import fr.solocal.domain.*;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("userDAO")
public class UserDAOImpl extends Requester implements UserDAO {
    private static final String SERVER_ADDRESS  = "http://91.134.242.201";
    private static final String SAVING_PATH = "/home/stage01/Images/";
    @Override
    public List<User> getRanking(String pEmail) throws Exception {
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);
        return null;
    }

    @Override
    public List<Achievement> getAllAchievements(String pEmail) throws Exception{
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);
        return achievementsFromJson(jsonResponse);
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);

        return userFromJson(jsonResponse);
    }

    @Override
    public void achieveChallenge(String pIdChallenge, String pEmail, String pPhoto) throws Exception {
        String url = SERVER_ADDRESS+"/elastic-pjrace/pjrace_challenge/user/"+pEmail+"/_update";

        Challenge challenge = new ChallengeDAOImpl().getChallengeById(pIdChallenge);
        User user = this.connexion(pEmail, "xxx");

        String photoPath = "xxx.png";
        //String photoPath = this.saveImage(pPhoto, pIdChallenge);

        JSONObject jsonScript = jsonScriptToUpdate(challenge, user, photoPath);


        super.sendPostRequest(url, jsonScript);
    }

    public User userFromJson(String pJsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(pJsonString);
        JSONObject userInfos = new JSONObject(jsonObject.getString("_source"));

        String firstname = userInfos.getString("firstname");
        String lastname = userInfos.getString("lastname");
        String email = userInfos.getString("email");
        int score = 0;

        JSONArray achievementsTab = new JSONArray(userInfos.getString("achievements"));

        for(int i=0; i<achievementsTab.length(); i++){
            score += achievementsTab.getJSONObject(i).getInt("score");
        }

        User user = new User();
        //TODO:SET L'ID USER
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setScore(score);

        return user;
    }

    public List<Achievement> achievementsFromJson(String pJsonString) throws JSONException {
        List<Achievement> lstAchievements = new ArrayList<>();
        int score = 0;

        JSONObject jsonObject = new JSONObject(pJsonString);
        JSONObject userInfos = new JSONObject(jsonObject.getString("_source"));
        JSONArray achievementsTab = new JSONArray(userInfos.getString("achievements"));

        for(int i=0; i<achievementsTab.length(); i++){
            score += achievementsTab.getJSONObject(i).getInt("score");
            //TODO: revoir l'id d'une resolution et rajouter des informations sur les challenges dans User sur l'ES
            String idAchievement = achievementsTab.getJSONObject(i).getString("idChallenge")+"_res";

            String idChallenge = achievementsTab.getJSONObject(i).getString("idChallenge");
            Challenge challenge = new Challenge();
            challenge.setIdChallenge(idChallenge);

            String photoUrl = achievementsTab.getJSONObject(i).getString("photoUrl");
            Achievement achievement = new Achievement(idAchievement, challenge, photoUrl);
            lstAchievements.add(achievement);
        }
        return lstAchievements;
    }

    public JSONObject jsonScriptToUpdate(Challenge pChallenge, User pUser, String pPhotoPath) throws Exception {
        int finalScore = pChallenge.getPoints()+pUser.getScore();

        //Construction du json permettant l'update de l'utilisateur
        JSONObject jsonAchievementData = new JSONObject();
        jsonAchievementData.put("idChallenge", pChallenge.getIdChallenge());
        jsonAchievementData.put("score",pChallenge.getPoints());
        jsonAchievementData.put("photoUrl",pPhotoPath);
        jsonAchievementData.put("dateCreated", dateOfToday());

        JSONObject jsonNewAchievement = new JSONObject();
        jsonNewAchievement.put("new_achv", jsonAchievementData);

        JSONObject jsonParameters = new JSONObject();
        jsonParameters.put("inline", "ctx._source.achievements.add(params.new_achv);ctx._source.score="+finalScore);
        jsonParameters.put("params", jsonNewAchievement);

        JSONObject jsonScript = new JSONObject();
        jsonScript.put("script", jsonParameters);

        return jsonScript;
    }

    public String  saveImage(String pImageEncoding, String pIdChallenge) throws IOException {
        Random randomGenerator = new Random();
        String photoName = pIdChallenge+randomGenerator.nextInt(1000)+".png";

        byte[] imageByteArray = Base64.decodeBase64(pImageEncoding);
        FileOutputStream imageOutFile = new FileOutputStream(SAVING_PATH+photoName);

        imageOutFile.write(imageByteArray);
        imageOutFile.close();

        return SAVING_PATH+photoName;
    }

    public String dateOfToday() {
        Long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
