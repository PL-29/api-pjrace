package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class ChallengeType {
    int idChallengeType;
    String title;
    int defaultNumberPoints;
    String description;

    public ChallengeType(int pIdChallengeType, String pTitle, int pDefaultNumberPoints, String pDescription) {
        this.idChallengeType = pIdChallengeType;
        this.title = pTitle;
        this.defaultNumberPoints = pDefaultNumberPoints;
        this.description = pDescription;
    }

    public ChallengeType() {
    }

    public int getpIdChallengeType() {
        return idChallengeType;
    }

    public void setpIdChallengeType(int pIdChallengeType) {
        this.idChallengeType = pIdChallengeType;
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
