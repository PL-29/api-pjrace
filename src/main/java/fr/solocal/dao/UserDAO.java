package fr.solocal.dao;

import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface UserDAO {
    public List<User> getRanking() throws Exception ;

    public List<Achievement> getAllAchievements(int idUser) throws Exception ;

    public User connexion(String email, String password) throws Exception ;

    public void achieveChallenge(int idChallenge, int idUser, String photo) throws Exception ;
}
