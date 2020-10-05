package com.pens.covidapp.model.covid_02;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataProvince {

    @SerializedName("data")
    @Expose
    private List<Province> data = null;

    public List<Province> getData() {
        return data;
    }

    public void setData(List<Province> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataProvince{" +
                "data=" + data +
                '}';
    }
}
