package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Etablissement;
import fr.solocal.service.EtablissementService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("etablissementService")
public class EtablissementServiceImpl implements EtablissementService {

    @Inject
    private CentralDAO dao;

    @Override
    public Iterator<Etablissement> getEtablissementsByPosition(double latitude, double longitude, int rayon) {
        return dao.getEtablissementsByPosition(latitude, longitude);
    }
}
