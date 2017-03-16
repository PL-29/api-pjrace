package fr.solocal.builder;

import fr.solocal.domain.Challenge;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class AchievementDTO implements Serializable {
    int pIdResolution;
    Challenge pChallenge;
    String pUrlPhoto;

    public AchievementDTO() {
        this.pIdResolution = pIdResolution;
        this.pChallenge = pChallenge;
        this.pUrlPhoto = pUrlPhoto;
    }


    public int getpIdResolution() {
        return pIdResolution;
    }

    public void setpIdResolution(int pIdResolution) {
        this.pIdResolution = pIdResolution;
    }

    public Challenge getpChallenge() {
        return pChallenge;
    }

    public void setpChallenge(Challenge pChallenge) {
        this.pChallenge = pChallenge;
    }

    public String getpUrlPhoto() {
        return pUrlPhoto;
    }

    public void setpUrlPhoto(String pUrlPhoto) {
        this.pUrlPhoto = pUrlPhoto;
    }


}
