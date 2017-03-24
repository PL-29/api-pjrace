package fr.solocal.dao.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("userDAO")
public class UserDAOImpl extends Requester implements UserDAO {
    @Override
    public List<User> getRanking(String pEmail) throws Exception {
        String serverAddress = "http://91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return null;
    }

    @Override
    public List<Achievement> getAllAchievements(String pEmail) throws Exception{
        String serverAddress = "http://91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return achievementsFromJson(jsonResponse);
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        String serverAddress = "http://91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);

        return userFromJson(jsonResponse);
    }

    @Override
    public void achieveChallenge(String pIdChallenge, String pIdUser, String pPhoto) throws Exception {

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
}
