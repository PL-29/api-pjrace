package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class Facility {
    int codeEtab;
    String denomination;
    String address;
    List<Challenge> challenges = new ArrayList<Challenge>();

    public Facility(int codeEtab, String denomination, String address) {
        this.codeEtab = codeEtab;
        this.denomination = denomination;
        this.address = address;
    }

    public Facility() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
