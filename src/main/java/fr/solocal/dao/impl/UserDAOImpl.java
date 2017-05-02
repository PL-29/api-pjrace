package fr.solocal.dao.impl;

import fr.solocal.dao.ChallengeDAO;
import fr.solocal.dao.UserDAO;
import fr.solocal.domain.*;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.File;
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
    private static final String SAVING_PATH = "/home/pjrace";

    public class IndexUser {
        private int value = 0;

        public IndexUser(){}

        public int getValue(){ return this.value; }

        public void setValue(int newValue){ this.value = newValue;}
    }


    @Override
    public List<User> getRanking(String pEmail) throws Exception {
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/pjrace_challenge/user/_search?sort=score:desc";
        String jsonResponse;
        IndexUser indexUser = new IndexUser();

        jsonResponse = super.sendGetRequest(url);
        List<User> lstUsers = UsersListFromJson(pEmail, jsonResponse, indexUser);
        return makeRanking(lstUsers, indexUser);
    }


    @Override
    public List<Achievement> getAllAchievements(String pEmail) throws Exception{
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);
        return achievementsFromJson(jsonResponse);
    }


    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = SERVER_ADDRESS+"/pjrace_challenge/user/_search?q=email:\""+pEmail+"\" AND password:\""+pPassword+"\"";
        String jsonResponse;

        //TODO: RENVOYER MESSAGE D ERREUR SI MOT DE PASSE OU ID INCORRECTS
        jsonResponse = super.sendGetRequest(url);

        return userFromJson(jsonResponse, pPassword);
    }


    @Override
    public Achievement achieveChallenge(String pPhotoEncoding, String pIdChallenge, String pEmail) throws Exception {
        String url = SERVER_ADDRESS+"/pjrace_challenge/user/"+pEmail+"/_update";

        Challenge challenge = new ChallengeDAOImpl().getChallengeById(pIdChallenge);
        User user = getUserInfosByEmail(pEmail);

        JSONObject jsonScript = jsonScriptToUpdate(challenge, user, SAVING_PATH);
        String urlPhoto = saveImage(pPhotoEncoding, pIdChallenge);

        super.sendPostRequest(url, jsonScript);

        Achievement achievement = new Achievement();
        achievement.setIdAchievement(challenge.getIdChallenge()+"_"+user.getIdUser());
        achievement.setChallenge(challenge);
        achievement.setUrlPhoto(urlPhoto);
        achievement.setUser(user);

        return achievement;
    }


    private User getUserInfosByEmail(String pEmail) throws Exception {
        String url = SERVER_ADDRESS+"/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(url);

        return userFromJson(jsonResponse);
    }


    public User userFromJson(String pJsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(pJsonString);
        JSONObject userInfos = new JSONObject(jsonObject.getString("_source"));

        int score = 0;

        JSONArray achievementsTab = new JSONArray(userInfos.getString("achievements"));

        for(int i=0; i<achievementsTab.length(); i++){
            score += achievementsTab.getJSONObject(i).getInt("score");
        }

        User user = new User();
        user.setIdUser(userInfos.getString("email"));
        user.setFirstname(userInfos.getString("firstname"));
        user.setLastname(userInfos.getString("lastname"));
        user.setEmail(userInfos.getString("email"));
        user.setScore(score);

        return user;
    }

    public User userFromJson(String pJsonString, String pPassword) throws JSONException {
        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonHits = new JSONArray(hits);
        JSONObject userInfos = new JSONObject(jsonHits.getJSONObject(0).getString("_source"));

        User user = new User();
        user.setIdUser(userInfos.getString("email"));
        user.setFirstname(userInfos.getString("firstname"));
        user.setLastname(userInfos.getString("lastname"));
        user.setEmail(userInfos.getString("email"));
        user.setScore(userInfos.getInt("score"));

        return user;
    }


    public List<Achievement> achievementsFromJson(String pJsonString) throws JSONException {
        List<Achievement> lstAchievements = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(pJsonString);
        JSONObject userInfos = new JSONObject(jsonObject.getString("_source"));
        JSONArray achievementsTab = new JSONArray(userInfos.getString("achievements"));

        for(int i=0; i<achievementsTab.length(); i++){
            JSONObject currentAchievement = achievementsTab.getJSONObject(i);
            String idAchievement = currentAchievement.getString("idChallenge")+"_res";

            String idChallenge = currentAchievement.getString("idChallenge");
            String dateCreated = currentAchievement.getString("dateCreated");
            Challenge challenge = new Challenge();
            challenge.setIdChallenge(idChallenge);
            challenge.setDateCreated(dateCreated);
            User user = new User();
            user.setLastname(userInfos.getString("lastname"));
            user.setFirstname(userInfos.getString("firstname"));
            user.setEmail(userInfos.getString("email"));
            user.setIdUser(userInfos.getString("email"));


            String photoUrl = currentAchievement.getString("photoUrl");

            Achievement achievement = new Achievement(idAchievement, challenge, photoUrl, user);
            lstAchievements.add(achievement);
        }
        return lstAchievements;
    }


    public List<User> UsersListFromJson(String pEmailUser, String pJsonString, IndexUser pIndexUser) throws JSONException {
        List<User> lstUsers = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(pJsonString);
        String hits = jsonObject.getJSONObject("hits").getString("hits");
        JSONArray jsonArray = new JSONArray(hits);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject source = jsonArray.getJSONObject(i).getJSONObject("_source");
            if(source.getString("email").equals(pEmailUser)){
                pIndexUser.setValue(i);
            }
            User user = new User();
            user.setIdUser(source.getString("email"));
            user.setEmail(source.getString("email"));
            user.setScore(source.getInt("score"));
            user.setFirstname(source.getString("firstname"));
            user.setLastname(source.getString("lastname"));
            user.setRank(i+1);
            lstUsers.add(user);
        }

        return lstUsers;
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


    public List<User> makeRanking(List<User> lstUsers, IndexUser indexUser){
        List<User> lstRanking = new ArrayList<>();

        if(lstUsers.size() >= 8){
            if(indexUser.getValue()== 0 || indexUser.getValue()== 1 || indexUser.getValue()== 2){
                for(int i = 0; i < 6 ; i++){
                    lstRanking.add(lstUsers.get(i));
                }
            } else {
                lstRanking.add(lstUsers.get(0));
                lstRanking.add(lstUsers.get(1));
                lstRanking.add(lstUsers.get(2));

                lstRanking.add(lstUsers.get(indexUser.getValue()-2));
                lstRanking.add(lstUsers.get(indexUser.getValue()-1));
                lstRanking.add(lstUsers.get(indexUser.getValue()));
                lstRanking.add(lstUsers.get(indexUser.getValue()+1));
                lstRanking.add(lstUsers.get(indexUser.getValue()+2));
            }
        }

        return lstRanking;
    }


    public String saveImage(String pImageEncoding, String pIdChallenge) throws IOException {
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
