package com.example.irishka.timetable.ui.myTrips.view;

import com.arellomobile.mvp.MvpView;
import com.example.irishka.timetable.domain.entities.Trip;

import java.util.List;

public interface MyTripsView extends MvpView{

    void showMyTrips(List<Trip> trips);
}
