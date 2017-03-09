package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Challenge {
    String pIdChallenge;
    Etablissement pEtablissement;
    ChallengeType pType;
    int pPoints;

    public Challenge(String pIdChallenge, Etablissement pEtablissement, ChallengeType pType, int pPoints) {
        this.pIdChallenge = pIdChallenge;
        this.pEtablissement = pEtablissement;
        this.pType = pType;
        this.pPoints = pPoints;
    }

    public Challenge() {
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
