package fr.solocal.builder;

import java.io.Serializable;

/**
 * Created by stage04 on 10/03/17.
 */
public class CoordonneeDTO implements Serializable {

    private static final long pSerialVersionUID = -1676589098064280755L;

    /** La latitude de la localité */
    private float lat;

    /** La longitude de la localité */
    private float lng;

    public CoordonneeDTO() {
        super();
    }

    public CoordonneeDTO(final float pLatitude, final float pLongitude) {
        super();
        this.lat = pLatitude;
        this.lng = pLongitude;
    }

    public static long getSerialVersionUID() {
        return pSerialVersionUID;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
