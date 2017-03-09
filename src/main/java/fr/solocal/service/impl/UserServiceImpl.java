package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.User;
import fr.solocal.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Inject
    private CentralDAO dao;

    @Override
    public Iterator<User> getRanking(int pIdUser) {
        return dao.getRanking();
    }

    @Override
    public User connexion(String pEmail, String pPassword) {
        return dao.connexion(pEmail, pPassword);
    }
}
