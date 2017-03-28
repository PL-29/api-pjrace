package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class ChallengeType {
    private String idChallengeType = "";
    private String title = "";
    private String description ="";
    private int defaultNumberOfPoints;

    ChallengeType(String idChallengeType, String title, String description, int defaultNumberOfPoints){
        this.idChallengeType = idChallengeType;
        this.title = title;
        this.description = description;
        this.defaultNumberOfPoints = defaultNumberOfPoints;
    }

    public String getIdChallengeType() {
        return idChallengeType;
    }

    public void setIdChallengeType(String idChallengeType) {
        this.idChallengeType = idChallengeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDefaultNumberOfPoints() {
        return defaultNumberOfPoints;
    }

    public void setDefaultNumberOfPoints(int defaultNumberOfPoints) {
        this.defaultNumberOfPoints = defaultNumberOfPoints;
    }
}
