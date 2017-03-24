package fr.solocal.dao;

import fr.solocal.domain.Challenge;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface ChallengeDAO {
    public Challenge getChallengeById(String pIdChallenge) throws Exception;

    public List<Challenge> getChallengesByCodeEtab(int pCodeEtab) throws Exception;
}
