package fr.solocal.builder;

import fr.solocal.domain.Challenge;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class AchievementDTO implements Serializable {
    String idResolution;
    String idChallenge;
    String urlPhoto;
    String idUser;
    String dateCreated;

    public AchievementDTO() {
    }

    public String getIdResolution() {
        return idResolution;
    }

    public void setIdResolution(String idResolution) {
        this.idResolution = idResolution;
    }

    public String getIdChallenge() {
        return idChallenge;
    }

    public void setIdChallenge(String idChallenge) {
        this.idChallenge = idChallenge;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
