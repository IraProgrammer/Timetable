package com.example.irishka.timetable.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.irishka.timetable.data.database.AppDatabase;
import com.example.irishka.timetable.data.database.dao.TripDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DatabaseModule {

    @Singleton
    @Provides
    static AppDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    static TripDao provideTripDao(AppDatabase database){
        return database.getTripDao();
    }

}
