package com.pens.covidapp.api;

import com.pens.covidapp.model.indonesia.DataProvince;
import com.pens.covidapp.model.indonesia.Indonesia;
import com.pens.covidapp.model.summary.Summary;
import com.pens.covidapp.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {


    //================URL Indonesia================//
    @GET("/indonesia/")
    Call<List<Indonesia>> getIndonesia();

    @GET("/api/provinsi")
    Call<DataProvince> getProvince();

    //URL Summary World
    @GET(Constant.END_POINT_SUMMARY)
    Call<Summary> getSummary();


}
