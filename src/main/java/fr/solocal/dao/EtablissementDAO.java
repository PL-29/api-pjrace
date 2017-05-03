package fr.solocal.dao;

import fr.solocal.domain.Etablissement;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface EtablissementDAO {
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws Exception;

    public JSONObject getDistanceToClosestChallenge(String pLatitude, String pLongitude) throws Exception;
}
