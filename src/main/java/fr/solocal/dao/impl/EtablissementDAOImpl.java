package fr.solocal.dao.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Etablissement;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
@Repository("etablissementDAO")
public class EtablissementDAOImpl extends Requester implements EtablissementDAO{
    @Override
    public List<Etablissement> getEtablissementsByPosition(double pLatitude, double pLongitude, int pRayon) throws Exception {
        String serverAddress = "http://91.134.242.201";
        String url = "/elastic-pjrace/pjrace_challenge/_search";
        String jsonResponse;

        jsonResponse = super.sendGetRequest(serverAddress+url);
        System.out.println(jsonResponse);
        return null;
    }
}
