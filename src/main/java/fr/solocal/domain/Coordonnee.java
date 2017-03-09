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
    private float pLat;

    /** La longitude de la localité */
    private float pLng;

    public Coordonnee() {
        super();
    }

    public Coordonnee(final float pLatitude, final float pLongitude) {
        super();
        this.pLat = pLatitude;
        this.pLng = pLongitude;
    }



    public float getLat() {
        return pLat;
    }

    public void setLat(final float pLatitude) {
        this.pLat = pLatitude;
    }

    public float getpLng() {
        return pLng;
    }

    public void setpLng(final float pLongitude) {
        this.pLng = pLongitude;
    }

    @Override
    public String toString() {
        return "Coordonnee [pLatitude=" + pLat + ", pLongitude=" + pLng + "]";
    }

}
