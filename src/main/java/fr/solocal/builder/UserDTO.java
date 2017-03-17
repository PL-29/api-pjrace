package fr.solocal.builder;

import fr.solocal.domain.Achievement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage04 on 10/03/17.
 */
public class UserDTO implements Serializable {
    int idUser;
    String lastname;
    String firstname;
    String email;
    String password;
    int rank;
    List<Achievement> achievements = new ArrayList<>();

    public UserDTO(int pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, List<Achievement> achievements) {
        this.idUser = pIdUser;
        this.lastname = pLastname;
        this.firstname = pFirstname;
        this.email = pEmail;
        this.password = pPassword;
        this.rank = pRank;
        this.achievements = achievements;
    }

    public UserDTO() {
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

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
}

