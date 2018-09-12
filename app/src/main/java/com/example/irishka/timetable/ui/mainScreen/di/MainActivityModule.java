package com.example.irishka.timetable.ui.mainScreen.di;

import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.di.scopes.PerFragmentInFragment;
import com.example.irishka.timetable.ui.addTrip.di.AddTripFragmentModule;
import com.example.irishka.timetable.ui.addTrip.view.AddTripFragment;
import com.example.irishka.timetable.ui.description.di.DescriptionFragmentModule;
import com.example.irishka.timetable.ui.description.view.DescriptionFragment;
import com.example.irishka.timetable.ui.mainScreen.InfoFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;
import com.example.irishka.timetable.ui.myTrips.di.MyTripsFragmentModule;
import com.example.irishka.timetable.ui.myTrips.view.MyTripsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = {StationsFragmentModule.class})
    abstract StationsFragment providesStationsFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {InfoFragmentModule.class})
    abstract InfoFragment providesInfoFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {DescriptionFragmentModule.class})
    abstract DescriptionFragment providesDescriptionFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {AddTripFragmentModule.class})
    abstract AddTripFragment providesAddTripFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {MyTripsFragmentModule.class})
    abstract MyTripsFragment providesMyTripsFragment();
}
