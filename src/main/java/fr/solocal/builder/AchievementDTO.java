package fr.solocal.builder;

import fr.solocal.domain.Challenge;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class AchievementDTO implements Serializable {
    int idResolution;
    Challenge challenge;
    String urlPhoto;

    public AchievementDTO() {
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
