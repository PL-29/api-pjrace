package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.dao.UserDAO;
import fr.solocal.domain.User;
import fr.solocal.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Inject
    private UserDAO userDAO;

    @Override
    public List<User> getRanking(String pEmail) throws Exception {
        return userDAO.getRanking(pEmail);
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws Exception {
        return userDAO.connexion(pEmail, pPassword);
    }
}
