package fr.solocal.domain;

/**
 * Created by stage01 on 10/02/17.
 */
public class Resolution {
    int idResolution;
    String urlPhoto;

    public Resolution(int idResolution, String urlPhoto) {
        this.idResolution = idResolution;
        this.urlPhoto = urlPhoto;
    }

    public Resolution() {
    }

    public int getIdResolution() {
        return idResolution;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
