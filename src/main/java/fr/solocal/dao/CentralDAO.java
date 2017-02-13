package fr.solocal.dao;

import fr.solocal.domain.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public interface CentralDAO {
    public Iterator<ChallengeType> getAllChallengeTypes();

    public Iterator<Challenge> getAllChallenges();

    public Challenge getChallengeById(int idChallenge);

    public Iterator<Challenge> getChallengeByCodeEtab(int codeEtab);

    public Iterator<Etablissement> getAllEtablissements();

    public Iterator<User> getRanking();

    public Iterator<Resolution> getAllAchievements(int idUser);

    public User connexion(String email, String password);

    public void achieveChallenge(int idChallenge, int idUser, String photo);
}
