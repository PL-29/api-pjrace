package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class User {
    int idUser;
    String lastname;
    String firstname;
    String email;
    String password;
    int rank;
    List<Achievement> achievements = new ArrayList<>();

    public User(int pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, List<Achievement> pAchievements) {
        this.idUser = pIdUser;
        this.lastname = pLastname;
        this.firstname = pFirstname;
        this.email = pEmail;
        this.password = pPassword;
        this.rank = pRank;
        this.achievements = pAchievements;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int pIdUser) {
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

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> pAchievements) {
        this.achievements = pAchievements;
    }

    public int getTotalScore(){
        int totalScore = 0;
        for(Achievement a : achievements){
            totalScore+= a.getpChallenge().getpPoints();
        }

        return totalScore;
    }
}
