package com.github.artsiomshshshsk.shopping.util;

import com.github.artsiomshshshsk.shopping.model.user.Geolocation;

public class GeolocationUtils {

    private final static double EARTH_RADIUS = 6371; //kilometers

    public static double distance(Geolocation from, Geolocation to) {
        double lat1 = from.getLat();
        double lat2 = to.getLat();
        double lng1 = from.getLng();
        double lng2 = to.getLng();

        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return EARTH_RADIUS * c;
    }
}
