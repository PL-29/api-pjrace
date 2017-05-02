package fr.solocal.service.impl;

import fr.solocal.dao.UserDAO;
import fr.solocal.domain.Achievement;
import fr.solocal.service.AchievementService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("achievementService")
public class AchievementServiceImpl implements AchievementService{

    @Inject
    UserDAO userDAO;

    @Override
    public List<Achievement> getAllResolutions(String pEmail) throws Exception {
        return userDAO.getAllAchievements(pEmail);
    }

    @Override
    public Achievement achieveChallenge(String pPhotoEncoding, String pIdChallenge, String pIdUser) throws Exception {
        return userDAO.achieveChallenge(pPhotoEncoding, pIdChallenge, pIdUser);
    }
}
