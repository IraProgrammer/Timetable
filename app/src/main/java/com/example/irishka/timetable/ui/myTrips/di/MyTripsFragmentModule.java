package com.example.irishka.timetable.ui.myTrips.di;

import android.support.v7.widget.LinearLayoutManager;

import com.example.irishka.timetable.di.scopes.PerActivity;
import com.example.irishka.timetable.di.scopes.PerFragment;
import com.example.irishka.timetable.ui.myTrips.view.MyTripsAdapter;
import com.example.irishka.timetable.ui.myTrips.view.MyTripsFragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MyTripsFragmentModule {

    @Provides
    @PerFragment
    static LinearLayoutManager providesLinearLayoutManager(MyTripsFragment myTripsFragment){
        return new LinearLayoutManager(myTripsFragment.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Provides
    @PerFragment
    static MyTripsAdapter providesMainFilmsAdapter(){
        return new MyTripsAdapter();
    }

}
