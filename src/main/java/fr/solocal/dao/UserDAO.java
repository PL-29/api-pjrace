package fr.solocal.dao;

import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface UserDAO {
    public List<User> getRanking();

    public List<Achievement> getAllAchievements(int idUser);

    public User connexion(String email, String password);

    public void achieveChallenge(int idChallenge, int idUser, String photo);
}
