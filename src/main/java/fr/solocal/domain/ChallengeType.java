package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class ChallengeType {
    int idChallengeType;
    String title;
    int defaultNumberPoints;
    String description;

    public ChallengeType(int idChallengeType, String title, int defaultNumberPoints, String description) {
        this.idChallengeType = idChallengeType;
        this.title = title;
        this.defaultNumberPoints = defaultNumberPoints;
        this.description = description;
    }

    public ChallengeType() {
    }

    public int getIdChallengeType() {
        return idChallengeType;
    }

    public void setIdChallengeType(int idChallengeType) {
        this.idChallengeType = idChallengeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDefaultNumberPoints() {
        return defaultNumberPoints;
    }

    public void setDefaultNumberPoints(int defaultNumberPoints) {
        this.defaultNumberPoints = defaultNumberPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
