package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Achievement {
    String idResolution;
    Challenge challenge;
    String urlPhoto;

    public Achievement(String pIdResolution, Challenge pChallenge, String pUrlPhoto) {
        this.idResolution = pIdResolution;
        this.challenge = pChallenge;
        this.urlPhoto = pUrlPhoto;
    }

    public Achievement() {
    }

    public String getIdResolution() {
        return idResolution;
    }

    public void setIdResolution(String pIdResolution) {
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
