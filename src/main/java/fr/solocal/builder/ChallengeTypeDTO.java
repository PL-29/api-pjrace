package fr.solocal.builder;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class ChallengeTypeDTO implements Serializable {

    int idChallengeType;
    String title;
    int defaultNumberPoints;
    String description;

    public ChallengeTypeDTO(int pIdChallengeType, String pTitle, int pDefaultNumberPoints, String pDescription) {
        this.idChallengeType = pIdChallengeType;
        this.title = pTitle;
        this.defaultNumberPoints = pDefaultNumberPoints;
        this.description = pDescription;
    }

    public ChallengeTypeDTO() {
    }

    public int getIdChallengeType() {
        return idChallengeType;
    }

    public void setIdChallengeType(int pidChallengeType) {
        idChallengeType = pidChallengeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String pTitle) {
        this.title = pTitle;
    }

    public int getDefaultNumberPoints() {
        return defaultNumberPoints;
    }

    public void setDefaultNumberPoints(int pDefaultNumberPoints) {
        this.defaultNumberPoints = pDefaultNumberPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        this.description = pDescription;
    }
}
