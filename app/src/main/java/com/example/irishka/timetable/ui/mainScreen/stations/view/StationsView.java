package com.example.irishka.timetable.ui.mainScreen.stations.view;

import android.support.v4.util.Pair;

import com.arellomobile.mvp.MvpView;
import com.example.irishka.timetable.domain.entities.Station;

import java.util.List;

public interface StationsView extends MvpView{

    void showStations(List<Pair<String, List<Station>>> stations);
}
