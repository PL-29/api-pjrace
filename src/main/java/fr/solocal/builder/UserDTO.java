package fr.solocal.builder;

import fr.solocal.domain.Achievement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage04 on 10/03/17.
 */
public class UserDTO implements Serializable {
    int pIdUser;
    String pLastname;
    String pFirstname;
    String pEmail;
    String pPassword;
    int pRank;
    List<Achievement> achievements = new ArrayList<>();

    public UserDTO(int pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, List<Achievement> achievements) {
        this.pIdUser = pIdUser;
        this.pLastname = pLastname;
        this.pFirstname = pFirstname;
        this.pEmail = pEmail;
        this.pPassword = pPassword;
        this.pRank = pRank;
        this.achievements = achievements;
    }

    public UserDTO() {
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

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
}

