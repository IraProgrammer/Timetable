package com.example.irishka.timetable.ui.mainScreen.di;

import android.support.v7.widget.LinearLayoutManager;

import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.di.scopes.PerFragmentInFragment;
import com.example.irishka.timetable.ui.description.di.DescriptionFragmentModule;
import com.example.irishka.timetable.ui.description.view.DescriptionFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StationsFragmentModule {
//    @Provides
//    @PerFragment
//    static StationsAdapter providesStationsAdapter() {
//        return new StationsAdapter();
//    }

//    @PerFragmentInFragment
//    @ContributesAndroidInjector(modules = {DescriptionFragmentModule.class})
//    abstract DescriptionFragment providesDescriptionFragment();

//    @Provides
//    @PerFragment
//    static LinearLayoutManager providesLinearLayoutManager(StationsFragment stationsFragment){
//        return new LinearLayoutManager(stationsFragment.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//    }
}
