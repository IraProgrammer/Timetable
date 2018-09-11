package com.example.irishka.timetable.data.repository;

import android.content.Context;
import android.support.v4.util.Pair;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.data.mappers.StationsMapper;
import com.example.irishka.timetable.data.models.AllStationsModel;
import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;
import com.example.irishka.timetable.domain.repository.IStationsRepository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StationsRepository implements IStationsRepository {

    private StationsMapper stationsMapper;

    private Context context;

    @Inject
    StationsRepository(StationsMapper stationsMapper, Context context) {
        this.stationsMapper = stationsMapper;
        this.context =  context;
    }

    public String loadJSONFromAsset() throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.all_stations);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        return writer.toString();
    }

    @Override
    public List<Country> getStationsList() {

        AllStationsModel allStationsModel = null;
        try {
            allStationsModel = new Gson()
                    .fromJson(loadJSONFromAsset(), AllStationsModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stationsMapper.mapAllStations(allStationsModel);
    }
}
