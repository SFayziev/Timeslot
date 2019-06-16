package com.sh.timeslot.common;


import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class LsConstant {


    public static final String DatePattern= "MM/dd/yyyy";
    public static final String TimePattern= "HH:mm:ss";
    public static final String DateTimePattern= DatePattern + " " + TimePattern;
    public static final String NullDateTime= "00/00/0000 00:00:00";
    public static final String NullDate= "00/00/0000";
    public static final String NULL_DIFF_DATE = "0 day";
    public static final ZoneId DEFAULT_TIME_ZONE_ID= ZoneId.of("UTC");

    public  static DateTimeFormatter localDateFormatter = java.time.format.DateTimeFormatter.ofPattern(DatePattern );
    public  static DateTimeFormatter localDateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(DateTimePattern);

}
