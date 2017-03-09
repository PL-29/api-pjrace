package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class ChallengeType {
    int pIdChallengeType;
    String pTitle;
    int pDefaultNumberPoints;
    String pDescription;

    public ChallengeType(int pIdChallengeType, String pTitle, int pDefaultNumberPoints, String pDescription) {
        this.pIdChallengeType = pIdChallengeType;
        this.pTitle = pTitle;
        this.pDefaultNumberPoints = pDefaultNumberPoints;
        this.pDescription = pDescription;
    }

    public ChallengeType() {
    }

    public int getpIdChallengeType() {
        return pIdChallengeType;
    }

    public void setpIdChallengeType(int pIdChallengeType) {
        this.pIdChallengeType = pIdChallengeType;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public int getpDefaultNumberPoints() {
        return pDefaultNumberPoints;
    }

    public void setpDefaultNumberPoints(int pDefaultNumberPoints) {
        this.pDefaultNumberPoints = pDefaultNumberPoints;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }
}
