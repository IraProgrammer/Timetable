package com.example.irishka.timetable.ui.mainScreen.stations.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.irishka.timetable.domain.repository.IStationsRepository;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsView;

import javax.inject.Inject;

@InjectViewState
public class StationsPresenter extends MvpPresenter<StationsView> {

    private IStationsRepository stationsRepository;

    @Inject
    public StationsPresenter(IStationsRepository repository) {
        this.stationsRepository = repository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getStations();
    }

    private void getStations() {

        getViewState().showStations(stationsRepository.getStationsList());
    }
}
