package com.example.irishka.timetable.domain.repository;

import android.support.v4.util.Pair;

import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;

import java.util.List;

import io.reactivex.Single;

public interface IStationsRepository {

    List<Country> getStationsList();
}
