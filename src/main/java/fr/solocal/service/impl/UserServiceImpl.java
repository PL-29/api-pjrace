package fr.solocal.service.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.User;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;
import fr.solocal.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Inject
    private UserDAO userDAO;

    @Override
    public List<User> getRanking(String pEmail) throws PJRaceException, PJRaceRuntimeException {
        return userDAO.getRanking(pEmail);
    }

    @Override
    public User connexion(String pEmail, String pPassword) throws PJRaceException, PJRaceRuntimeException {
        return userDAO.connexion(pEmail, pPassword);
    }
}
