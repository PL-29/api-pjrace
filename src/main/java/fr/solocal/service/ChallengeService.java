package fr.solocal.service;

import fr.solocal.domain.Challenge;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface ChallengeService {
    //Permet de récupérer les challenges
    public List<Challenge> getAllChallenges() throws Exception;

    //Permet de récupérer un challenge grâce à son id
    public Challenge getChallengeById(String pIdChallenge) throws Exception;


    //Permet de récupérer un challenge grâce à son codeEtab
    public List<Challenge> getChallengeByCodeEtab(int pCodeEtab) throws Exception;
}
