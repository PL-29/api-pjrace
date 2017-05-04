package fr.solocal.service;

import fr.solocal.domain.Challenge;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface ChallengeService {
    //Permet de récupérer un challenge grâce à son id
    public Challenge getChallengeById(String pIdChallenge) throws PJRaceException, PJRaceRuntimeException;


    //Permet de récupérer un challenge grâce à son codeEtab
    public List<Challenge> getChallengeByCodeEtab(int pCodeEtab) throws PJRaceException, PJRaceRuntimeException;
}
