package fr.solocal.service;

import fr.solocal.domain.Etablissement;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface EtablissementService {
    //Permet de récupérer les etablissements
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws PJRaceException, PJRaceRuntimeException;

    public double getDistanceToClosestEtablissement(String pLatitude, String pLongitude) throws  PJRaceException, PJRaceRuntimeException;
}
