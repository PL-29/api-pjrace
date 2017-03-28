package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public enum ChallengeType {
    photo("photo", "Challenge photo", "Prenez une photo de la devanture de l'établissement", 100),
    horaires("horaires", "Challenge horaires", "Prenez une photo de la plage horaires de l'établissement", 100),
    menu("menu", "Challenge menu", "Prenez une photo du menu de l'établissement", 100),
    paiement("paiement", "Challenge paiement", "Prenez une photo des moyens de paiement autorisés par l'établissement", 100);

    private String idChallengeType = "";
    private String title = "";
    private String description ="";
    private int defaultNumberOfPoints;

    ChallengeType(String idChallengeType, String title, String description, int defaultNumberOfPoints){
        this.idChallengeType = idChallengeType;
        this.title = title;
        this.description = description;
        this.defaultNumberOfPoints = defaultNumberOfPoints;
    }

    public String getIdChallengeType() {
        return idChallengeType;
    }

    public void setIdChallengeType(String idChallengeType) {
        this.idChallengeType = idChallengeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDefaultNumberOfPoints() {
        return defaultNumberOfPoints;
    }

    public void setDefaultNumberOfPoints(int defaultNumberOfPoints) {
        this.defaultNumberOfPoints = defaultNumberOfPoints;
    }
}
