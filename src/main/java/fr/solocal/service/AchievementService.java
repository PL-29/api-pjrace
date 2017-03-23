package fr.solocal.service;

import fr.solocal.domain.Achievement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface AchievementService {

    public List<Achievement> getAllResolutions(String pEmail) throws Exception;

    public void achieveChallenge(String pIdChallenge, String pIdUser, String pPhoto) throws Exception;
}
