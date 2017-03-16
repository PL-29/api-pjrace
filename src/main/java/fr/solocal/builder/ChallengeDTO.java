package fr.solocal.builder;

import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class ChallengeDTO implements Serializable {
    String pIdChallenge;
    Etablissement pEtablissement;
    ChallengeType pType;
    int pPoints;

    public ChallengeDTO(String pIdChallenge, Etablissement pEtablissement, ChallengeType pType, int pPoints) {
        this.pIdChallenge = pIdChallenge;
        this.pEtablissement = pEtablissement;
        this.pType = pType;
        this.pPoints = pPoints;
    }

    public ChallengeDTO() {
    }

    public String getpIdChallenge() {
        return pIdChallenge;
    }

    public void setpIdChallenge(String pIdChallenge) {
        this.pIdChallenge = pIdChallenge;
    }

    public Etablissement getpEtablissement() {
        return pEtablissement;
    }

    public void setpEtablissement(Etablissement pEtablissement) {
        this.pEtablissement = pEtablissement;
    }

    public ChallengeType getpType() {
        return pType;
    }

    public void setpType(ChallengeType pType) {
        this.pType = pType;
    }

    public int getpPoints() {
        return pPoints;
    }

    public void setpPoints(int pPoints) {
        this.pPoints = pPoints;
    }
}
