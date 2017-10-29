package com.timmytime.util;

import java.util.ArrayList;
import java.util.List;

public class GeoCacheUtils {

    public static final Integer LNG_ZONES_COUNT = Integer.valueOf(System.getenv("lng_zones_count"));
    public static final Integer LNG_OFFSET = Integer.valueOf(System.getenv("lng_offset"));
    public static final Integer LAT_OFFSET = Integer.valueOf(System.getenv("lat_offset"));
    public static final Integer LNG_DEGREES = Integer.valueOf(System.getenv("lng_degrees"));
    public static final Integer LAT_DEGREES = Integer.valueOf(System.getenv("lat_degrees"));
    public static final Double LNG_SUB_DEGREES = Double.valueOf(System.getenv("lng_sub_degrees"));
    public static final Double LAT_SUB_DEGREES = Double.valueOf(System.getenv("lat_sub_degrees"));


    public static final List<String> LAT_VALUES = new ArrayList<String>() {{
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
        add("H");
        add("J");
        add("K");
        add("L");
        add("M");
        add("N");
        add("P");
        add("Q");
        add("R");
        add("S");
        add("T");
        add("U");
        add("V");
        add("W");
        add("X");
    }};


}
