package com.example.irishka.timetable.ui.mainScreen.di;

import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.ui.mainScreen.InfoFragment;
import com.example.irishka.timetable.ui.mainScreen.TimetableFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = {TimetableFragmentModule.class})
    abstract TimetableFragment providesTimetableFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {InfoFragmentModule.class})
    abstract InfoFragment providesInfoFragment();

}
