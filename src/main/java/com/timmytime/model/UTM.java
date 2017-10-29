package com.timmytime.model;

public class UTM {

    private String utmLat;
    private String utmLng;


    public UTM(String utmLat, String utmLng) {
        this.utmLat = utmLat;
        this.utmLng = utmLng;

    }

    public String getUtmLat() {
        return utmLat;
    }

    public String getUtmLng() {
        return utmLng;
    }

    public String toString() {
        return utmLat + utmLng;
    }
}
