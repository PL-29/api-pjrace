package fr.solocal.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stage01 on 10/02/17.
 */
public class Etablissement {
    int pCodeEtab;
    String pDenomination;
    String pAddress;
    double pLatitude;
    double pLongitude;
    List<Challenge> pChallenges = new ArrayList<Challenge>();

    public Etablissement(int pCodeEtab, String pDenomination, String pAddress, double pLatitude, double pLongitude, List<Challenge> pChallenges) {
        this.pCodeEtab = pCodeEtab;
        this.pDenomination = pDenomination;
        this.pAddress = pAddress;
        this.pLatitude = pLatitude;
        this.pLongitude = pLongitude;
        this.pChallenges = pChallenges;
    }

    public Etablissement() {
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

    public List<Challenge> getpChallenges() {
        return pChallenges;
    }

    public void setpChallenges(List<Challenge> pChallenges) {
        this.pChallenges = pChallenges;
    }
}
