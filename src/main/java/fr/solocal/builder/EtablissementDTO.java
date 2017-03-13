package fr.solocal.builder;

import fr.solocal.domain.Challenge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage04 on 10/03/17.
 */
public class EtablissementDTO implements Serializable {

    int pCodeEtab;
    String pDenomination;
    String pAddress;
    double pLatitude;
    double pLongitude;
    List<Challenge> challenges = new ArrayList<Challenge>();

    public EtablissementDTO(int pCodeEtab, String pDenomination, String pAddress, double pLatitude, double pLongitude) {
        this.pCodeEtab = pCodeEtab;
        this.pDenomination = pDenomination;
        this.pAddress = pAddress;
        this.pLatitude = pLatitude;
        this.pLongitude = pLongitude;
    }

    public EtablissementDTO() {
    }

    public int getpCodeEtab() {
        return pCodeEtab;
    }

    public void setpCodeEtab(int pCodeEtab) {
        this.pCodeEtab = pCodeEtab;
    }

    public String getpDenomination() {
        return pDenomination;
    }

    public void setpDenomination(String pDenomination) {
        this.pDenomination = pDenomination;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public double getpLatitude() {
        return pLatitude;
    }

    public void setpLatitude(double pLatitude) {
        this.pLatitude = pLatitude;
    }

    public double getpLongitude() {
        return pLongitude;
    }

    public void setpLongitude(double pLongitude) {
        this.pLongitude = pLongitude;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
