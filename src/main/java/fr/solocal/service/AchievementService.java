package fr.solocal.service;

import fr.solocal.domain.Resolution;

import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
public interface AchievementService {

    public Iterator<Resolution> getAllResolutions(int idUser);

    public void achieveChallenge(int idChallenge, int idUSer, String photo);
}
