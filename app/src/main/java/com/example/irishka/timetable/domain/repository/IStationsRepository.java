package com.example.irishka.timetable.domain.repository;

import android.support.v4.util.Pair;

import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;
import com.example.irishka.timetable.domain.entities.Trip;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;

public interface IStationsRepository {

    void insertTrip(Trip trip);

    Single<List<Trip>> getTrips();

    List<Country> getStationsList();

    List<Country> getFilteredStationsList(String query);

    Map<String, List<String>> getFromMap();

    Map<String, List<String>> getToMap();
}
