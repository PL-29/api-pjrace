package fr.solocal.dao;

import fr.solocal.domain.*;

import java.util.Iterator;

/**
 * Created by stage01 on 10/02/17.
 */
public interface CentralDAO {
    public Iterator<ChallengeType> getAllChallengeTypes();

    public Iterator<Challenge> getAllChallenges();

    public Challenge getChallengeById(String idChallenge);

    public Iterator<Challenge> getChallengesByCodeEtab(int codeEtab);

    public Iterator<Etablissement> getEtablissementsByPosition(double latitude, double longitude);

    public Iterator<User> getRanking();

    public Iterator<Achievement> getAllAchievements(int idUser);

    public User connexion(String email, String password);

    public void achieveChallenge(int idChallenge, int idUser, String photo);
}
