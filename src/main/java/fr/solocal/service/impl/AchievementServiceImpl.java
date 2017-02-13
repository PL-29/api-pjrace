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
    public Iterator<Achievement> getAllResolutions(int idUser) {
        return dao.getAllAchievements(idUser);
    }

    @Override
    public void achieveChallenge(int idChallenge, int idUSer, String photo) {
        dao.achieveChallenge(idChallenge, idUSer, photo);
    }
}
