package fr.solocal.dao;

import fr.solocal.domain.Achievement;
import fr.solocal.domain.User;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface UserDAO {
    public List<User> getRanking(String pEmail) throws PJRaceException, PJRaceRuntimeException;

    public List<Achievement> getAllAchievements(String pEmail) throws PJRaceException, PJRaceRuntimeException ;

    public User connexion(String email, String password) throws PJRaceException, PJRaceRuntimeException ;

    public Achievement achieveChallenge(String pPhotoEncoding, String idChallenge, String idUser) throws PJRaceException, PJRaceRuntimeException ;
}
