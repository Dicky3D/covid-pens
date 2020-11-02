package com.pens.covidapp.utils;

import retrofit2.http.GET;

public class Constant {

    public static final String BASE_URL_01 = "https://covid19.mathdro.id";
    public static final String BASE_URL_02 = "https://api.kawalcorona.com";

    //end point base url_01
    public static final String END_POINT_SUMMARY_WORLD = "/api";
    public static final String END_POINT_IDN = "/api/countries/IDN";
    public static final String END_POINT_WORLD_HISTORY = "/api/daily/{date}";

    //end point base url_02
    public static final String END_POINT_INDONESIA = "/indonesia/";
    public static final String END_POINT_COUNTRY ="/";

    //end point base url_03
    public static final String END_POINT_PROVINSI= "/api/provinsi/";

    //end point base SUMMARY
    public static final String END_POINT_SUMMARY = "/summary";


    public static final String covid_01 = "covid01";
    public static final String covid_02 = "covid02";
    public static final String covid_03 = "covid03";

    public static final String date_01 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String date_02 = "yyyy-MM-dd HH:mm:ss";
    public static final String date_03 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String date_04 = "yyyyMMddHHmmssSSS";
    public static final String date_05 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String date_06 = "yyyy-MM-dd'T'HH:mm:ss'Z'";


//2020-08-19T16:27:42.000Z
    public static final String msg_internet="Koneksi internet bermasalah";
    public static final String country_indonesia="Indonesia";

    public static final String send_kasus="sendKasus";
    public static final String send_positif="sendPositif";
    public static final String send_sembuh="sendSembuh";
    public static final String send_mati="sendMati";
    public static final String send_country="sendCountry";

    public static final String kontak_wa="Whatsapp";
    public static final String kontak_ig="Instagram";
    public static final String kontak_github="Github";

    public static final String data_undefined="Undefined";
}
