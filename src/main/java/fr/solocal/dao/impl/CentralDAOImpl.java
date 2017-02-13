package fr.solocal.dao.impl;

import com.codahale.metrics.annotation.Timed;
import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.Challenge;
import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
@Repository("centralDAO")
public class CentralDAOImpl implements CentralDAO{
    private List<ChallengeType> challengeTypes = new ArrayList<ChallengeType>();
    private List<Challenge> challenges = new ArrayList<Challenge>();

    public CentralDAOImpl() {
        //---- ChallengeType : PHOTO ----
        ChallengeType type = new ChallengeType();
        type.setIdChallengeType(1);
        type.setDescription("Prenez une photo de la devanture de l'établissement");
        type.setDefaultNumberPoints(100);
        type.setTitle("Photo");
        challengeTypes.add(type);


        //---- Etablissement ----
        Etablissement etab = new Etablissement();
        etab.setCodeEtab(1205);
        etab.setAdresse("1 rue de la République, 35000 Rennes");
        etab.setDenomination("Bar des sports");


        //---- Challenges ----
        Challenge c1 = new Challenge();
        c1.setEtablissement(etab);
        c1.setType(type);
        c1.setPoints(100);

        Challenge c2 = new Challenge();
        c2.setEtablissement(etab);
        c2.setType(type);
        c2.setPoints(200);

        Challenge c3 = new Challenge();
        c3.setEtablissement(etab);
        c3.setType(type);
        c3.setPoints(300);

        challenges.add(c1);
        challenges.add(c2);
        challenges.add(c3);
    }

    @Override
    @Timed(absolute = true, name = "challenge_types")
    public Iterator<ChallengeType> getAllChallengeTypes(){
        return challengeTypes.iterator();
    }

    @Override
    @Timed(absolute = true, name = "challenges")
    public Iterator<Challenge> getAllChallenges() {
        return challenges.iterator();
    }

    @Override
    @Timed(absolute = true, name = "challenge_id")
    public Challenge getChallengeById(int idChallenge) {
        return null;
    }

    @Override
    @Timed(absolute = true, name = "challenge_codeEtab")
    public List<Challenge> getChallengeByCodeEtab(int codeEtab) {
        return null;
    }
}
