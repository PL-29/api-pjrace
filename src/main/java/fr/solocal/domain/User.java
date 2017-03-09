package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class User {
    int pIdUser;
    String pLastname;
    String pFirstname;
    String pEmail;
    String pPassword;
    int pRank;
    List<Achievement> pAchievements = new ArrayList<>();

    public User(int pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, List<Achievement> pAchievements) {
        this.pIdUser = pIdUser;
        this.pLastname = pLastname;
        this.pFirstname = pFirstname;
        this.pEmail = pEmail;
        this.pPassword = pPassword;
        this.pRank = pRank;
        this.pAchievements = pAchievements;
    }

    public User() {
    }

    public int getpIdUser() {
        return pIdUser;
    }

    public void setpIdUser(int pIdUser) {
        this.pIdUser = pIdUser;
    }

    public String getpLastname() {
        return pLastname;
    }

    public void setpLastname(String pLastname) {
        this.pLastname = pLastname;
    }

    public String getpFirstname() {
        return pFirstname;
    }

    public void setpFirstname(String pFirstname) {
        this.pFirstname = pFirstname;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpPassword() {
        return pPassword;
    }

    public void setpPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public int getpRank() {
        return pRank;
    }

    public void setpRank(int pRank) {
        this.pRank = pRank;
    }

    public List<Achievement> getpAchievements() {
        return pAchievements;
    }

    public void setpAchievements(List<Achievement> pAchievements) {
        this.pAchievements = pAchievements;
    }

    public int getTotalScore(){
        int totalScore = 0;
        for(Achievement a : pAchievements){
            totalScore+= a.getpChallenge().getpPoints();
        }

        return totalScore;
    }
}
