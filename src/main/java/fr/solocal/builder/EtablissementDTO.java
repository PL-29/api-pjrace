package fr.solocal.builder;

import fr.solocal.domain.Challenge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage04 on 10/03/17.
 */
public class EtablissementDTO implements Serializable {

    int codeEtab;
    String denomination;
    String address;
    double latitude;
    double longitude;
    List<Challenge> challenges = new ArrayList<Challenge>();

    public EtablissementDTO(int pCodeEtab, String pDenomination, String pAddress, double pLatitude, double pLongitude) {
        this.codeEtab = pCodeEtab;
        this.denomination = pDenomination;
        this.address = pAddress;
        this.latitude = pLatitude;
        this.longitude = pLongitude;
    }

    public EtablissementDTO() {
    }

    public int getCodeEtab() {
        return codeEtab;
    }

    public void setCodeEtab(int pCodeEtab) {
        this.codeEtab = pCodeEtab;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String pDenomination) {
        this.denomination = pDenomination;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String pAddress) {
        this.address = pAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double pLatitude) {
        this.latitude = pLatitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double pLongitude) {
        this.longitude = pLongitude;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
