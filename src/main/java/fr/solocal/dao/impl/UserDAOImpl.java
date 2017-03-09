package fr.solocal.dao.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;

import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getRanking() {
        return null;
    }

    @Override
    public List<Achievement> getAllAchievements(int pIdUser) {
        return null;
    }

    @Override
    public User connexion(String pEmail, String pPassword) {
        return null;
    }

    @Override
    public void achieveChallenge(int pIdChallenge, int pIdUser, String pPhoto) {

    }
}
