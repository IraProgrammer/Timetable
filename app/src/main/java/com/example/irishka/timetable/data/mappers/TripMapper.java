package com.example.irishka.timetable.data.mappers;

import android.support.v4.util.Pair;

import com.example.irishka.timetable.data.database.entity.TripDb;
import com.example.irishka.timetable.data.models.AllStationsModel;
import com.example.irishka.timetable.data.models.StationModel;
import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;
import com.example.irishka.timetable.domain.entities.Trip;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TripMapper {

    @Inject
    TripMapper() {
    }

    public Trip applyFromDb(TripDb tripDb){
        Trip trip = new Trip();
        trip.setDate(tripDb.getDate());
        trip.setFrom(tripDb.getFrom());
        trip.setTo(tripDb.getTo());

        return trip;
    }

    public TripDb applyToDb(Trip trip){
        TripDb tripDb = new TripDb();
        tripDb.setDate(trip.getDate());
        tripDb.setFrom(trip.getFrom());
        tripDb.setTo(trip.getTo());

        return tripDb;
    }

    public List<Trip> mapTripsListFromDb(List<TripDb> tripsDb) {
        List<Trip> trips = new ArrayList<>();

        for (int i = 0; i < tripsDb.size(); i++) {
            trips.add(applyFromDb(tripsDb.get(i)));
        }

        return trips;
    }
}
