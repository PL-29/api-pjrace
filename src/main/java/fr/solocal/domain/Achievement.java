package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Achievement {
    int pIdResolution;
    Challenge pChallenge;
    String pUrlPhoto;

    public Achievement(int pIdResolution, Challenge pChallenge, String pUrlPhoto) {
        this.pIdResolution = pIdResolution;
        this.pChallenge = pChallenge;
        this.pUrlPhoto = pUrlPhoto;
    }

    public Achievement() {
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
