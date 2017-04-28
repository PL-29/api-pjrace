package fr.solocal.dao;

import fr.solocal.domain.Etablissement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 06/03/17.
 */
public interface EtablissementDAO {
    public List<Etablissement> getEtablissementsByPosition(String pLatitude, String pLongitude, String pRayon) throws Exception;
}
