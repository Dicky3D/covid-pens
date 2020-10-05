
package com.pens.covidapp.model.covid_01;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SummaryWorld {

    @SerializedName("confirmed")
    @Expose
    private Confirmed confirmed;
    @SerializedName("recovered")
    @Expose
    private Recovered recovered;
    @SerializedName("deaths")
    @Expose
    private Deaths deaths;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;

    public Confirmed getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Confirmed confirmed) {
        this.confirmed = confirmed;
    }

    public Recovered getRecovered() {
        return recovered;
    }

    public void setRecovered(Recovered recovered) {
        this.recovered = recovered;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "SummaryWorld{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
