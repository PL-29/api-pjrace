package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Challenge {
    String idChallenge = "";
    Etablissement etablissement = null;
    ChallengeType type = null;
    int points = 0;
    String dateCreated = "";

    public Challenge(String pIdChallenge, Etablissement pEtablissement, ChallengeType pType, int pPoints) {
        this.idChallenge = pIdChallenge;
        this.etablissement = pEtablissement;
        this.type = pType;
        this.points = pPoints;
    }

    public Challenge() {
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

    public String getDateCreated() { return dateCreated;}

    public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated;}
}
