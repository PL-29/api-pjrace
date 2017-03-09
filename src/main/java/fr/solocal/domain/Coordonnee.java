package fr.solocal.domain;

import java.io.Serializable;

/**
 * Classe representant les coordonnées d'une localité ainsi que son type géographique
 * @author scollet
 *
 */
public class Coordonnee implements Serializable {

    private static final long pSerialVersionUID = -1676589098064280755L;

    /** La latitude de la localité */
    private float lat;

    /** La longitude de la localité */
    private float lng;

    public Coordonnee() {
        super();
    }

    public Coordonnee(final float pLatitude, final float pLongitude) {
        super();
        this.lat = pLatitude;
        this.lng = pLongitude;
    }



    public float getLat() {
        return lat;
    }

    public void setLat(final float pLatitude) {
        this.lat = pLatitude;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(final float pLongitude) {
        this.lng = pLongitude;
    }

    @Override
    public String toString() {
        return "Coordonnee [latitude=" + lat + ", longitude=" + lng + "]";
    }

}
