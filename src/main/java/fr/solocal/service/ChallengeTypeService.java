package fr.solocal.service;

import fr.solocal.domain.ChallengeType;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public interface ChallengeTypeService  {
    //Permet de récupérer les types de challenge
    public List<ChallengeType> getAllChallengeTypes();
}
