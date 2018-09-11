
package com.example.irishka.timetable.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationModel {

    @SerializedName("countryTitle")
    @Expose
    private String countryTitle;
    @SerializedName("point")
    @Expose
    private PointModel point;
    @SerializedName("districtTitle")
    @Expose
    private String districtTitle;
    @SerializedName("cityId")
    @Expose
    private long cityId;
    @SerializedName("cityTitle")
    @Expose
    private String cityTitle;
    @SerializedName("regionTitle")
    @Expose
    private String regionTitle;
    @SerializedName("stationId")
    @Expose
    private long stationId;
    @SerializedName("stationTitle")
    @Expose
    private String stationTitle;

    public String getCountryTitle() {
        return countryTitle;
    }

    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    public PointModel getPoint() {
        return point;
    }

    public void setPoint(PointModel point) {
        this.point = point;
    }

    public String getDistrictTitle() {
        return districtTitle;
    }

    public void setDistrictTitle(String districtTitle) {
        this.districtTitle = districtTitle;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getRegionTitle() {
        return regionTitle;
    }

    public void setRegionTitle(String regionTitle) {
        this.regionTitle = regionTitle;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public void setStationTitle(String stationTitle) {
        this.stationTitle = stationTitle;
    }

}
