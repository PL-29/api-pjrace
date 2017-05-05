package fr.solocal.service.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Etablissement;
import fr.solocal.exceptions.PJRaceException;
import fr.solocal.exceptions.PJRaceRuntimeException;
import fr.solocal.service.EtablissementService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("etablissementService")
public class EtablissementServiceImpl implements EtablissementService {

    @Inject
    private EtablissementDAO etablissementDAO;

    @Override
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws PJRaceException, PJRaceRuntimeException {
        return etablissementDAO.getEtablissementsByPosition(pLatitude, pLongitude, pRayon);
    }

    @Override
    public double getDistanceToClosestEtablissement(String pLatitude, String pLongitude) throws PJRaceException, PJRaceRuntimeException {
        return etablissementDAO.getDistanceToClosestEtablissement(pLatitude, pLongitude);
    }
}
