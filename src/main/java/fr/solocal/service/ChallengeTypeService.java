package fr.solocal.service;

import fr.solocal.domain.ChallengeType;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public interface ChallengeTypeService  {
    //Permet de récupérer les types de challenge
    public List<ChallengeType> getAllChallengeTypes() throws PJRaceException, PJRaceRuntimeException;
}
