package fr.solocal.service.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Etablissement;
import fr.solocal.service.EtablissementService;
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
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws Exception {
        return etablissementDAO.getEtablissementsByPosition(pLatitude, pLongitude, pRayon);
    }

    @Override
    public int getDistanceToClosestChallenge(String pLatitude, String pLongitude, String pRayon) throws Exception {
        return etablissementDAO.getDistanceToClosestChallenge(pLatitude, pLongitude, pRayon);
    }


}
