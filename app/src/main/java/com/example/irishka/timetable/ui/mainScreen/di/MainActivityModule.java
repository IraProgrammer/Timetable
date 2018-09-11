package com.example.irishka.timetable.ui.mainScreen.di;

import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.ui.mainScreen.InfoFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = {StationsFragmentModule.class})
    abstract StationsFragment providesTimetableFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {InfoFragmentModule.class})
    abstract InfoFragment providesInfoFragment();

}
