package fr.solocal.dao;

import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface ChallengeDAO {
    public Challenge getChallengeById(String pIdChallenge) throws PJRaceException, PJRaceRuntimeException;

    public List<Challenge> getChallengesByCodeEtab(int pCodeEtab) throws PJRaceException, PJRaceRuntimeException;

    public List<ChallengeType> getAllChallengeTypes() throws  PJRaceException, PJRaceRuntimeException;
}
