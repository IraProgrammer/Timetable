package com.example.irishka.timetable.ui.addTrip.view;

import android.support.v4.util.Pair;

import com.arellomobile.mvp.MvpView;
import com.example.irishka.timetable.domain.entities.Country;

import java.util.List;
import java.util.Map;

public interface AddTripView extends MvpView{

    void showToast();

    void setFromMap(Map<String, List<String>> fromMap);

    void setToMap(Map<String, List<String>> toMap);
}
