package fr.solocal.service;

import fr.solocal.domain.User;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface UserService {
    public List<User> getRanking(String pEmail) throws PJRaceException, PJRaceRuntimeException;

    public User connexion(String pEmail, String pPassword) throws PJRaceException, PJRaceRuntimeException;
}
