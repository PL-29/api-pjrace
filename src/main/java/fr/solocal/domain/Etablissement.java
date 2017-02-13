package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class Etablissement {
    int codeEtab;
    String denomination;
    String adresse;
    List<Challenge> challenges = new ArrayList<Challenge>();

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

    public void setCodeEtab(int codeEtab) { this.codeEtab = codeEtab; }

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

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
