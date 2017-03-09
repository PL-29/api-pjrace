package fr.solocal.dao.impl;

import fr.solocal.dao.EtablissementDAO;
import fr.solocal.domain.Etablissement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public class EtablissementDAOImpl implements EtablissementDAO{
    @Override
    public List<Etablissement> getEtablissementsByPosition(double pLatitude, double pLongitude, int pRayon) {
        return null;
    }
}
