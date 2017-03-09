package fr.solocal.service;

import fr.solocal.domain.Etablissement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by stage01 on 13/02/17.
 */
public interface EtablissementService {
    //Permet de récupérer les etablissements
    public Iterator<Etablissement> getEtablissementsByPosition(double pLatitude, double pLongitude, int pRayon);
}
