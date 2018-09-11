package com.example.irishka.timetable.ui.mainScreen.di;

import android.support.v7.widget.LinearLayoutManager;

import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsAdapter;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class StationsFragmentModule {
    @Provides
    @PerFragment
    static StationsAdapter providesStationsAdapter() {
        return new StationsAdapter();
    }

    @Provides
    @PerFragment
    static LinearLayoutManager providesLinearLayoutManager(StationsFragment stationsFragment){
        return new LinearLayoutManager(stationsFragment.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    }
}
