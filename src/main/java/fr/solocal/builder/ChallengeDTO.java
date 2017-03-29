package fr.solocal.builder;

import fr.solocal.domain.ChallengeType;
import fr.solocal.domain.Etablissement;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class ChallengeDTO implements Serializable {
    String idChallenge = "";
    String idChallengeType = "";
    int points = 0;
    String dateCreated = "";

    public ChallengeDTO(String pIdChallenge, String pIdChallengeType, int pPoints) {
        this.idChallenge = pIdChallenge;
        this.idChallengeType = pIdChallengeType;
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

    public String getIdChallengeType() {
        return idChallengeType;
    }

    public void setIdChallengeType(String idChallengeType) {
        this.idChallengeType = idChallengeType;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int pPoints) {
        this.points = pPoints;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
