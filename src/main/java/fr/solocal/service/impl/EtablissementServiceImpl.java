package fr.solocal.service.impl;

import fr.solocal.dao.CentralDAO;
import fr.solocal.domain.Etablissement;
import fr.solocal.service.EtablissementService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
@Service("etablissementService")
public class EtablissementServiceImpl implements EtablissementService {

    @Inject
    private CentralDAO dao;

    @Override
    public Iterator<Etablissement> getEtablissementsByPosition(double latitude, double longitude) {
        return dao.getEtablissementsByPosition(latitude, longitude);
    }
}
