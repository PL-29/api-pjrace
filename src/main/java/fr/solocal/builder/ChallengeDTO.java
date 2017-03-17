package fr.solocal.builder;

import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class ChallengeDTO implements Serializable {
    String idChallenge;
    Etablissement etablissement;
    ChallengeType type;
    int points;

    public ChallengeDTO(String pIdChallenge, Etablissement pEtablissement, ChallengeType pType, int pPoints) {
        this.idChallenge = pIdChallenge;
        this.etablissement = pEtablissement;
        this.type = pType;
        this.points = pPoints;
    }

    public ChallengeDTO() {
    }

    public String getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(String pIdChallenge) {
        this.idChallenge = pIdChallenge;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement pEtablissement) {
        this.etablissement = pEtablissement;
    }

    public ChallengeType getType() {
        return type;
    }

    public void setType(ChallengeType pType) {
        this.type = pType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int pPoints) {
        this.points = pPoints;
    }
}
