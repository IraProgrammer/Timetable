package com.example.irishka.timetable.data.mappers;

import android.graphics.Movie;
import android.support.v4.util.Pair;

import com.example.irishka.timetable.data.models.AllStationsModel;
import com.example.irishka.timetable.data.models.CitiesFromModel;
import com.example.irishka.timetable.data.models.StationModel;
import com.example.irishka.timetable.domain.entities.Station;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class StationsMapper {

    @Inject
    StationsMapper() {
    }

    private Station apply(StationModel stationModel){
        Station station = new Station();
        station.setCityId(stationModel.getCityId());
        station.setCityTitle(stationModel.getCityTitle());
        station.setCountryTitle(stationModel.getCountryTitle());
        station.setDistrictTitle(stationModel.getDistrictTitle());
        station.setPoint(new Pair<>(stationModel.getPoint().getLongitude(), stationModel.getPoint().getLatitude()));
        station.setRegionTitle(stationModel.getRegionTitle());
        station.setStationId(stationModel.getStationId());
        station.setStationTitle(stationModel.getStationTitle());

        return station;
    }

    public List<Pair<String, List<Station>>> mapAllStations(AllStationsModel allStationsModel) {

        List<Pair<String, List<Station>>> list = new ArrayList<>();

        List<Station> stations;

        for (int i = 0; i<allStationsModel.getCitiesFrom().size(); i++) {

            stations = new ArrayList<>();

            for (int j = 0; j < allStationsModel.getCitiesFrom().get(i).getStations().size(); j++) {
                stations.add(apply(allStationsModel.getCitiesFrom().get(i).getStations().get(j)));
            }

            list.add(new Pair<>(allStationsModel.getCitiesFrom().get(i).getCityTitle().concat(allStationsModel.getCitiesFrom().get(i).getCountryTitle()), stations));

        }

        for (int i = 0; i<allStationsModel.getCitiesTo().size(); i++) {

            stations = new ArrayList<>();

            for (int j = 0; j < allStationsModel.getCitiesTo().get(i).getStations().size(); j++) {
                stations.add(apply(allStationsModel.getCitiesTo().get(i).getStations().get(j)));
            }
            list.add(new Pair<>(allStationsModel.getCitiesTo().get(i).getCityTitle().concat(allStationsModel.getCitiesTo().get(i).getCountryTitle()), stations));

        }

        return list;

    }

}
