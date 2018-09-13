package com.example.irishka.timetable.ui.addTrip.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.domain.repository.IStationsRepository;
import com.example.irishka.timetable.ui.BasePresenter;
import com.example.irishka.timetable.ui.addTrip.view.AddTripView;

import javax.inject.Inject;

@InjectViewState
public class AddTripPresenter extends BasePresenter<AddTripView> {

    private IStationsRepository stationsRepository;

    @Inject
    public AddTripPresenter(IStationsRepository repository) {
        this.stationsRepository = repository;
        getFromMap();
        getToMap();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void insertTrip(Trip trip) {
        stationsRepository.insertTrip(trip);
        getViewState().showToast();
    }

    private void getFromMap() {
        getViewState().setFromMap(stationsRepository.getFromMap());
    }

    private void getToMap() {
        getViewState().setToMap(stationsRepository.getToMap());
    }
}
