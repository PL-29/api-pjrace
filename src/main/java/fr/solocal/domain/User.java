package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class User {
    String idUser;
    String lastname;
    String firstname;
    String email;
    String password;
    int rank;
    int score;
    List<Achievement> achievements = new ArrayList<>();

    public User(String pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, int pScore, List<Achievement> pAchievements) {
        this.idUser = pIdUser;
        this.lastname = pLastname;
        this.firstname = pFirstname;
        this.email = pEmail;
        this.password = pPassword;
        this.rank = pRank;
        int score = pScore;
        this.achievements = pAchievements;
    }

    public User() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String pIdUser) {
        this.idUser = pIdUser;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String pLastname) {
        this.lastname = pLastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String pFirstname) {
        this.firstname = pFirstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        this.email = pEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        this.password = pPassword;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int pRank) {
        this.rank = pRank;
    }

    public int getScore() { return this.score; }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> pAchievements) {
        this.achievements = pAchievements;
    }
}
