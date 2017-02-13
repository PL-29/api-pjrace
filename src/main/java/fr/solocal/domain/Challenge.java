package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Challenge {
    int idChallenge;
    Facility facility;
    ChallengeType type;
    int points;

    public Challenge(int idChallenge, Facility facility, ChallengeType type, int points) {
        this.idChallenge = idChallenge;
        this.facility = facility;
        this.type = type;
        this.points = points;
    }

    public Challenge() {
    }

    public int getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(int idChallenge) {
        this.idChallenge = idChallenge;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
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
