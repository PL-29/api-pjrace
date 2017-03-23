package fr.solocal.service;

import fr.solocal.domain.User;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface UserService {
    public List<User> getRanking(String pEmail) throws Exception;

    public User connexion(String pEmail, String pPassword) throws Exception;
}
