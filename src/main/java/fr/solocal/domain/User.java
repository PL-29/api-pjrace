package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class User {
    int idUser;
    String nom;
    String prenom;
    String email;
    String password;

    public User(int idUser, String nom, String prenom, String email, String password) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User() {
    }


    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
