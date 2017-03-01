package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class Etablissement {
    int codeEtab;
    String denomination;
    String address;
    double latitude;
    double longitude;
    List<Challenge> challenges = new ArrayList<Challenge>();

    public Etablissement(int codeEtab, String denomination, String address, double latitude, double longitude) {
        this.codeEtab = codeEtab;
        this.denomination = denomination;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
