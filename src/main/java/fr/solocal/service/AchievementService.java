package fr.solocal.service;

import fr.solocal.domain.Achievement;

import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
public interface AchievementService {

    public Iterator<Achievement> getAllResolutions(int pIdUser);

    public void achieveChallenge(int pIdChallenge, int pIdUser, String pPhoto);
}
