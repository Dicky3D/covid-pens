package com.pens.covidapp.model.indonesia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Province {
    @SerializedName("fid")
    @Expose
    private Integer fid;
    @SerializedName("kodeProvi")
    @Expose
    private Integer kodeProvi;
    @SerializedName("provinsi")
    @Expose
    private String provinsi;
    @SerializedName("kasusPosi")
    @Expose
    private Integer kasusPosi;
    @SerializedName("kasusSemb")
    @Expose
    private Integer kasusSemb;
    @SerializedName("kasusMeni")
    @Expose
    private Integer kasusMeni;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getKodeProvi() {
        return kodeProvi;
    }

    public void setKodeProvi(Integer kodeProvi) {
        this.kodeProvi = kodeProvi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public Integer getKasusPosi() {
        return kasusPosi;
    }

    public void setKasusPosi(Integer kasusPosi) {
        this.kasusPosi = kasusPosi;
    }

    public Integer getKasusSemb() {
        return kasusSemb;
    }

    public void setKasusSemb(Integer kasusSemb) {
        this.kasusSemb = kasusSemb;
    }

    public Integer getKasusMeni() {
        return kasusMeni;
    }

    public void setKasusMeni(Integer kasusMeni) {
        this.kasusMeni = kasusMeni;
    }
}
