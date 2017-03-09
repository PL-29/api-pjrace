package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.Achievement;
import fr.solocal.service.AchievementService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("achievementService")
public class AchievementServiceImpl implements AchievementService{

    @Inject
    CentralDAO dao;

    @Override
    public Iterator<Achievement> getAllResolutions(int pIdUser) {
        return dao.getAllAchievements(pIdUser);
    }

    @Override
    public void achieveChallenge(int pIdChallenge, int pIdUser, String pPhoto) {
        dao.achieveChallenge(pIdChallenge, pIdUser, pPhoto);
    }
}
