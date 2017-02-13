package fr.solocal.dao;

import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public interface CentralDAO {
    public Iterator<ChallengeType> getAllChallengeTypes();

    public Iterator<Challenge> getAllChallenges();

    public Challenge getChallengeById(int idChallenge);

    public List<Challenge> getChallengeByCodeEtab(int codeEtab);
}
