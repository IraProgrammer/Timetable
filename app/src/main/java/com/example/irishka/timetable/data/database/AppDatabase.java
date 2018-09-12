package com.example.irishka.timetable.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.irishka.timetable.data.database.dao.TripDao;
import com.example.irishka.timetable.data.database.entity.TripDb;

@Database(entities = {TripDb.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "com.example.irishka.timetableDatabase";

    public abstract TripDao getTripDao();
}
