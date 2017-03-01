package fr.solocal.service;

import fr.solocal.domain.Challenge;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface ChallengeService {
    //Permet de récupérer les challenges
    public Iterator<Challenge> getAllChallenges();

    //Permet de récupérer un challenge grâce à son id
    public Challenge getChallengeById(String idChallenge);


    //Permet de récupérer un challenge grâce à son codeEtab
    public Iterator<Challenge> getChallengeByCodeEtab(int codeEtab);
}
