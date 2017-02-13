package fr.solocal.service;

import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;

import java.util.Iterator;

/**
 * Created by stage01 on 13/02/17.
 */
public interface EtablissementService {
    //Permet de récupérer les etablissements
    public Iterator<Etablissement> getAllEtablissements();
}
