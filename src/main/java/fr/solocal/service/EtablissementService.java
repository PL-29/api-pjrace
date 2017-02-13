package fr.solocal.service;

import fr.solocal.domain.Facility;

import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
public interface EtablissementService {
    //Permet de récupérer les etablissements
    public Iterator<Facility> getAllEtablissements();
}
