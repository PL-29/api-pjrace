package fr.solocal.dao;

import fr.solocal.domain.*;

import java.util.Iterator;

/**
 * Created by stage01 on 10/02/17.
 */
public interface CentralDAO {
    public Iterator<ChallengeType> getAllChallengeTypes();

    public Iterator<Challenge> getAllChallenges();

    public Challenge getChallengeById(int idChallenge);

    public Iterator<Challenge> getChallengeByCodeEtab(int codeEtab);

    public Iterator<Facility> getAllEtablissements();

    public Iterator<User> getRanking();

    public Iterator<Achievement> getAllAchievements(int idUser);

    public User connexion(String email, String password);

    public void achieveChallenge(int idChallenge, int idUser, String photo);
}
