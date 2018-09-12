package com.example.irishka.timetable.ui.myTrips.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.domain.repository.IStationsRepository;
import com.example.irishka.timetable.ui.BasePresenter;
import com.example.irishka.timetable.ui.myTrips.view.MyTripsView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

@InjectViewState
public class MyTripsPresenter extends BasePresenter<MyTripsView> {

    private IStationsRepository stationsRepository;

    @Inject
    public MyTripsPresenter(IStationsRepository repository) {
        this.stationsRepository = repository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getMyTrips();
    }

    private void getMyTrips() {

        addDisposables(
                stationsRepository.getTrips()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trips -> getViewState().showMyTrips(trips), throwable -> {
                }
                ));
    }
}
