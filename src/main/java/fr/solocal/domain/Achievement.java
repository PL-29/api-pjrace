package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Achievement {
    int idResolution;
    Challenge challenge;
    String urlPhoto;

    public Achievement(int pIdResolution, Challenge pChallenge, String pUrlPhoto) {
        this.idResolution = pIdResolution;
        this.challenge = pChallenge;
        this.urlPhoto = pUrlPhoto;
    }

    public Achievement() {
    }

    public int getIdResolution() {
        return idResolution;
    }

    public void setIdResolution(int pIdResolution) {
        this.idResolution = pIdResolution;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge pChallenge) {
        this.challenge = pChallenge;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String pUrlPhoto) {
        this.urlPhoto = pUrlPhoto;
    }
}
