package fr.solocal.builder;

import fr.solocal.domain.Achievement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage04 on 10/03/17.
 */
public class UserDTO implements Serializable {
    String idUser;
    String lastname;
    String firstname;
    String email;
    String password;
    int rank;
    int score;

    public UserDTO(String pIdUser, String pLastname, String pFirstname, String pEmail, String pPassword, int pRank, int score) {
        this.idUser = pIdUser;
        this.lastname = pLastname;
        this.firstname = pFirstname;
        this.email = pEmail;
        this.password = pPassword;
        this.rank = pRank;
        this.score = score;

    }

    public UserDTO() {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

