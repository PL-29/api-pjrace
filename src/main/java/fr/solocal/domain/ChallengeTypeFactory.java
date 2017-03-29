package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 28/03/17.
 */
public class ChallengeTypeFactory {

    public static ChallengeType makeChallengeType(String codeChallengeType)
    {
        ChallengeType challengeType = null;
        switch(codeChallengeType)
        {
            case "photo":
                    challengeType = new ChallengeType(codeChallengeType,"Challenge photo", "Prenez une photo de la devanture de l'établissement", 100 );
                break;
            case "horaires":
                challengeType = new ChallengeType(codeChallengeType, "Challenge horaires", "Prenez une photo de la plage horaires de l'établissement", 100);
                break;
            case "menu" :
                challengeType = new ChallengeType(codeChallengeType, "Challenge menu", "Prenez une photo du menu de l'établissement", 100);
                break;
            case "paiement" :
                challengeType = new ChallengeType(codeChallengeType, "Challenge paiement", "Prenez une photo des moyens de paiement autorisés par l'établissement", 100);
                break;
            case "rubriques" :
                challengeType = new ChallengeType(codeChallengeType, "Challenge rubriques", "DESCRIPTION A MODIFIER", 100);
                break;
        }
        return challengeType;
    }

    public static List<ChallengeType> makeChallengeTypeList(){
        List<ChallengeType> lstChallengeType = new ArrayList<>();

        ChallengeType photo = new ChallengeType("photo","Challenge photo", "Prenez une photo de la devanture de l'établissement", 100 );
        ChallengeType horaires = new ChallengeType("horaires","Challenge horaires", "Prenez une photo de la plage horaires de l'établissement", 100 );
        ChallengeType menu = new ChallengeType("menu","Challenge menu", "Prenez une photo du menu de l'établissement", 100 );
        ChallengeType paiement = new ChallengeType("paiement","Challenge paiement", "Prenez une photo des moyens de paiement autorisés par l'établissement", 100 );

        lstChallengeType.add(photo);
        lstChallengeType.add(horaires);
        lstChallengeType.add(menu);
        lstChallengeType.add(paiement);

        return lstChallengeType;
    }
}
