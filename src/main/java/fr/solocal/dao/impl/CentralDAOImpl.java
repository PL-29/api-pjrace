package fr.solocal.dao.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.ChallengeType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class CentralDAOImpl implements CentralDAO{
    private List<ChallengeType> challengeTypes;

    public CentralDAOImpl() {
        ChallengeType type = new ChallengeType();
        type.setIdChallengeType(1);
        type.setDescription("Prenez une photo de la devanture de l'établissement");
        type.setDefaultNumberPoints(100);
        type.setTitle("Photo");

        challengeTypes = new ArrayList<ChallengeType>();
        challengeTypes.add(type);
    }

    @Override
    public Iterator<ChallengeType> getAllChallengeTypes(){
        return challengeTypes.iterator();
    }
}
