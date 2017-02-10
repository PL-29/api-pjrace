package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Etablissement {
    int codeEtab;
    String denomination;
    String adresse;

    public Etablissement(int codeEtab, String denomination, String adresse) {
        this.codeEtab = codeEtab;
        this.denomination = denomination;
        this.adresse = adresse;
    }

    public Etablissement() {
    }

    public int getCodeEtab() {
        return codeEtab;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
