
package com.example.irishka.timetable.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.Pair;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station implements Parcelable {

    private String countryTitle;

    private Pair<Double, Double> point;

    private String districtTitle;

    private long cityId;

    private String cityTitle;

    private String regionTitle;

    private long stationId;

    private String stationTitle;

    public Station(){}

    protected Station(Parcel in) {
        countryTitle = in.readString();
        districtTitle = in.readString();
        cityId = in.readLong();
        cityTitle = in.readString();
        regionTitle = in.readString();
        stationId = in.readLong();
        stationTitle = in.readString();
    }

    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    public String getCountryTitle() {
        return countryTitle;
    }

    public void setCountryTitle(String countryTitle) {
        this.countryTitle = countryTitle;
    }

    public Pair<Double, Double> getPoint() {
        return point;
    }

    public void setPoint(Pair<Double, Double> point) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getStationTitle());
    }
}
