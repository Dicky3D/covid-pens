
package com.pens.covidapp.model.covid_country;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryList {


//    private Attributes attributes;
//    private List<Attributes> attributes;
//
//    public List<Attributes> getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(List<Attributes> attributes) {
//        this.attributes = attributes;
//    }

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public Attributes getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (Attributes attributes)
    {
        this.attributes = attributes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [attributes = "+attributes+"]";
    }
}
