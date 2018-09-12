package com.example.irishka.timetable.ui.addTrip.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.domain.repository.IStationsRepository;
import com.example.irishka.timetable.ui.BasePresenter;
import com.example.irishka.timetable.ui.addTrip.view.AddTripView;

import io.reactivex.android.schedulers.AndroidSchedulers;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

@InjectViewState
public class AddTripPresenter extends BasePresenter<AddTripView> {

    private IStationsRepository stationsRepository;

    @Inject
    public AddTripPresenter(IStationsRepository repository) {
        this.stationsRepository = repository;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void insertTrip(Trip trip) {

     //   addDisposables(
                stationsRepository.insertTrip(trip);
                getViewState().showToast();
              //  .observeOn(AndroidSchedulers.mainThread())
              //  .subscribe(keywords -> getViewState().showToast(), throwable -> {
              //  }
             //   ));
    }
}
