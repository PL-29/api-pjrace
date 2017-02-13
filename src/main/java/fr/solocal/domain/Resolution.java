package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Resolution {
    int idResolution;
    Challenge challenge;
    String urlPhoto;

    public Resolution(int idResolution, Challenge challenge, String urlPhoto) {
        this.idResolution = idResolution;
        this.challenge = challenge;
        this.urlPhoto = urlPhoto;
    }

    public Resolution() {
    }

    public int getIdResolution() {
        return idResolution;
    }

    public void setIdResolution(int idResolution) {
        this.idResolution = idResolution;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
