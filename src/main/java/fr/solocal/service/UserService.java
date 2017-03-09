package fr.solocal.service;

import fr.solocal.domain.User;

import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
public interface UserService {
    public Iterator<User> getRanking(int pIdUser);

    public User connexion(String pEmail, String pPassword);
}
