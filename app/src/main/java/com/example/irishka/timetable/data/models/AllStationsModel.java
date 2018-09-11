
package com.example.irishka.timetable.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllStationsModel {

    @SerializedName("citiesFrom")
    @Expose
    private List<CitiesFromModel> citiesFrom;
    @SerializedName("citiesTo")
    @Expose
    private List<CitiesToModel> citiesTo;

    public List<CitiesFromModel> getCitiesFrom() {
        return citiesFrom;
    }

    public void setCitiesFrom(List<CitiesFromModel> citiesFrom) {
        this.citiesFrom = citiesFrom;
    }

    public List<CitiesToModel> getCitiesTo() {
        return citiesTo;
    }

    public void setCitiesTo(List<CitiesToModel> citiesTo) {
        this.citiesTo = citiesTo;
    }

}
