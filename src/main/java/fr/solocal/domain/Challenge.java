package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Challenge {
    String idChallenge;
    Etablissement etablissement;
    ChallengeType type;
    int points;

    public Challenge(String idChallenge, Etablissement etablissement, ChallengeType type, int points) {
        this.idChallenge = idChallenge;
        this.etablissement = etablissement;
        this.type = type;
        this.points = points;
    }

    public Challenge() {
    }

    public String getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(String idChallenge) {
        this.idChallenge = idChallenge;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public ChallengeType getType() {
        return type;
    }

    public void setType(ChallengeType type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}