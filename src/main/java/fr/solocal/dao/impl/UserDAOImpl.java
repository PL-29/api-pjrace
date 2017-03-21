package fr.solocal.dao.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;

import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public class UserDAOImpl extends Requester implements UserDAO {
    @Override
    public List<User> getRanking() throws Exception {
        return null;
    }

    @Override
    public List<Achievement> getAllAchievements(int pIdUser) throws Exception{
        String serverAddress = "91.134.242.201";
        //L'idUser correspond à l'adresse mail de l'utilisateur /!\
        String url = "/elastic-pjrace/user/"+pIdUser;
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        return null;
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        return null;
    }

    @Override
    public void achieveChallenge(int pIdChallenge, int pIdUser, String pPhoto) throws Exception {

    }
}
