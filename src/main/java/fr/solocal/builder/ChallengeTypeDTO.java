package fr.solocal.builder;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class ChallengeTypeDTO implements Serializable {

    int pIdChallengeType;
    String pTitle;
    int pDefaultNumberPoints;
    String pDescription;

    public ChallengeTypeDTO(int pIdChallengeType, String pTitle, int pDefaultNumberPoints, String pDescription) {
        this.pIdChallengeType = pIdChallengeType;
        this.pTitle = pTitle;
        this.pDefaultNumberPoints = pDefaultNumberPoints;
        this.pDescription = pDescription;
    }

    public ChallengeTypeDTO() {
    }

    public int getPidChallengeType() {
        return pIdChallengeType;
    }

    public void setPidChallengeType(int pidChallengeType) {
        pIdChallengeType = pidChallengeType;
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
