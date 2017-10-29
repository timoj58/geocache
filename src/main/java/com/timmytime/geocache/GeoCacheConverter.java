package com.timmytime.geocache;

import com.timmytime.model.UTM;
import com.timmytime.reponse.GeoCacheResponse;
import com.timmytime.request.GeoCacheRequest;
import com.timmytime.util.GeoCacheUtils;

public class GeoCacheConverter{

    public static GeoCacheResponse convert(GeoCacheRequest geoCacheRequest){
        UTM utm = getUTMGrid(geoCacheRequest.getLatitude(), geoCacheRequest.getLongitude());

        GeoCacheResponse geoCacheResponse = new GeoCacheResponse(
                utm,
                getUTMSubGrid(utm, geoCacheRequest.getLatitude(),geoCacheRequest.getLongitude())
        );

        return geoCacheResponse;
    }


    private static UTM getUTMGrid(Double latitude, Double longitude) {
        return new UTM(latToUTM(latitude), longToUTM(longitude));
    }

    private static UTM getUTMSubGrid(UTM utm, Double latitude, Double longitude) {
        return new UTM(latToSubUTM(utm.getUtmLat(), latitude), longToSubUTM(utm.getUtmLng(), longitude));
    }

    private static String longToUTM(Double longitude) {
        //There are 60 longitudinal projection zones numbered 1 to 60 starting at 180°W. Each of these zones is 6 degrees wide, apart from a few exceptions around Norway and Svalbard.
        //rns -180 to 180
        return String.valueOf((int) Math.floor((longitude + GeoCacheUtils.LNG_OFFSET)) / GeoCacheUtils.LNG_DEGREES + 1);
    }

    private static String latToUTM(Double latitude) {
        //There are 20 latitudinal zones spanning the latitudes 80°S to 84°N and denoted by the letters C to X, ommitting the letter O. Each of these is 8 degrees south-north, apart from zone X which is 12 degrees south-north.
        //note some of W is wrong and who gives a fuck about X unless your a seal
        return GeoCacheUtils.LAT_VALUES.get((int) Math.floor((latitude + GeoCacheUtils.LAT_OFFSET) / GeoCacheUtils.LAT_DEGREES));
    }

    /*
      Basically the below is me bastardizing algorithm...it works.  test cases may be a pain in ass
      easch sub grid has a fucking lot of sectors...
     */

    private static String longToSubUTM(String utmLong, Double longitude) {
        final int end = (Integer.valueOf(utmLong) * GeoCacheUtils.LNG_DEGREES) - GeoCacheUtils.LNG_OFFSET;

        return String.valueOf((int) ((GeoCacheUtils.LNG_DEGREES - (end - longitude)) / GeoCacheUtils.LNG_SUB_DEGREES));
    }

    private static String latToSubUTM(String utmLat, Double latitude) {
        final int end = ((GeoCacheUtils.LAT_VALUES.indexOf(utmLat) + 1) * GeoCacheUtils.LAT_DEGREES) - GeoCacheUtils.LAT_OFFSET;
        final int sector = (int) ((GeoCacheUtils.LAT_DEGREES - (end - latitude)) / GeoCacheUtils.LAT_SUB_DEGREES);
        final int prefix = (int) Math.ceil((sector / GeoCacheUtils.LAT_VALUES.size()) + 1);

        return prefix + GeoCacheUtils.LAT_VALUES.get(sector - (GeoCacheUtils.LAT_VALUES.size() * (prefix - 1)));

    }

}
