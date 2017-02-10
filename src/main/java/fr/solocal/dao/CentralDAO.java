package fr.solocal.dao;

import fr.solocal.domain.ChallengeType;

import java.util.Iterator;

/**
 * Created by stage01 on 10/02/17.
 */
public interface CentralDAO {
    public Iterator<ChallengeType> getAllChallengeTypes();
}
