package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Achievement {
    String idAchievement;
    Challenge challenge;
    String urlPhoto;
    User user;

    public Achievement(String pIdAchievement, Challenge pChallenge, String pUrlPhoto, User pUser) {
        this.idAchievement = pIdAchievement;
        this.challenge = pChallenge;
        this.urlPhoto = pUrlPhoto;
        this.user = pUser;
    }

    public Achievement() {
    }

    public String getIdAchievement() {
        return idAchievement;
    }

    public void setIdAchievement(String pIdAchievement) {
        this.idAchievement = pIdAchievement;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
