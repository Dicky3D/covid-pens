package com.pens.covidapp.api;

import android.util.Log;

import com.pens.covidapp.BuildConfig;
import com.pens.covidapp.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit = null;

//    public static Retrofit getClient(String url) {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }

    public static Retrofit getClient(String baseURL) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Log.d("MainActivity","1 retrofit baseurl : "+retrofit.baseUrl());

        } else {
            if (!retrofit.baseUrl().equals(baseURL)) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Log.d("MainActivity","2 retrofit baseurl : "+retrofit.baseUrl());
            }
        }
        return retrofit;
    }



}
