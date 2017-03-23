package fr.solocal.dao.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;
import org.springframework.stereotype.Repository;

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
        System.out.println(jsonResponse);
        return null;
    }

    @Override
    public List<Achievement> getAllAchievements(String pEmail) throws Exception{
        String serverAddress = "http://91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        System.out.println(jsonResponse);
        return null;
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        String serverAddress = "http://91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/pjrace_challenge/user/"+pEmail;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        System.out.println(jsonResponse);
        return null;
    }

    @Override
    public void achieveChallenge(String pIdChallenge, String pIdUser, String pPhoto) throws Exception {

    }
}
