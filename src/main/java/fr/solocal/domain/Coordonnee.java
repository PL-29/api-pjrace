package fr.solocal.domain;

import java.io.Serializable;

/**
 * Classe representant les coordonnées d'une localité ainsi que son type géographique
 * @author scollet
 *
 */
public class Coordonnee implements Serializable {

    private static final long serialVersionUID = -1676589098064280755L;

    /** La latitude de la localité */
    private float lat;

    /** La longitude de la localité */
    private float lng;

    public Coordonnee() {
        super();
    }

    public Coordonnee(final float latitude, final float longitude) {
        super();
        this.lat = latitude;
        this.lng = longitude;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(final float latitude) {
        this.lat = latitude;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(final float longitude) {
        this.lng = longitude;
    }

    @Override
    public String toString() {
        return "Coordonnee [latitude=" + lat + ", longitude=" + lng + "]";
    }

}
