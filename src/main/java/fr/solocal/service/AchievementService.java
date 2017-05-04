package fr.solocal.service;

import fr.solocal.domain.Achievement;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface AchievementService {

    public List<Achievement> getAllResolutions(String pEmail) throws PJRaceException, PJRaceRuntimeException;

    public Achievement achieveChallenge(String pPhotoEncoding, String pIdChallenge, String pIdUser) throws PJRaceException, PJRaceRuntimeException;
}
