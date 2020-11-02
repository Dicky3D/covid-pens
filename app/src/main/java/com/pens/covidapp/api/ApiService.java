package com.pens.covidapp.api;

import com.pens.covidapp.model.covid_02.DataProvince;
import com.pens.covidapp.model.covid_02.Indonesia;
import com.pens.covidapp.model.covid_02.RootIndonesia;
import com.pens.covidapp.model.covid_country.CountryList;
import com.pens.covidapp.model.summary.Summary;
import com.pens.covidapp.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.pens.covidapp.model.covid_01.SummaryWorld;
import com.pens.covidapp.model.covid_01.CountryModel;

public interface ApiService {

    //================Service BASE URL 01================//
//    @GET(Constant.END_POINT_WORLD_HISTORY)
//    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Constant.END_POINT_SUMMARY_WORLD)
    Call<SummaryWorld> getSummaryWorld();

    @GET(Constant.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();

    //================Service BASE URL 02================//
    @GET("/indonesia/")
    Call<List<Indonesia>> getIndonesia();

    @GET("/")
    Call<CountryList> getCountry();


    //BASE URL03
    @GET("/api/provinsi")
    Call<DataProvince> getProvince();

    //BASE SUMMARY
    @GET(Constant.END_POINT_SUMMARY)
    Call<Summary> getSummary();


}
