package com.example.irishka.timetable.ui.description.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Station;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public class DescriptionFragment extends DaggerFragment {

    private static final String STATION_KEY = "concrete station";

    @BindView(R.id.tv_country)
    TextView countryTv;

    @BindView(R.id.tv_city)
    TextView cityTv;

    @BindView(R.id.tv_station)
    TextView stationTv;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.btn_home)
    ImageButton homeBtn;

    SupportMapFragment mapFragment;

    GoogleMap map;

    public static DescriptionFragment newInstance(Station station) {

        Bundle args = new Bundle();
        args.putParcelable(STATION_KEY, station);
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        descriptionFragment.setArguments(args);

        return descriptionFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_description, container, false);
        ButterKnife.bind(this, v);

        showDetails((Station) getArguments().get(STATION_KEY));

        return v;
    }

    public void showDetails(Station station) {

        homeBtn.setOnClickListener(view -> getActivity().onBackPressed());

        toolbarTitle.setText(station.getStationTitle());

        countryTv.setText(getResources().getString(R.string.details_country, station.getCountryTitle()));
        cityTv.setText(getResources().getString(R.string.details_city, station.getCityTitle()));
        stationTv.setText(getResources().getString(R.string.details_station, station.getStationTitle()));

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(googleMap -> {
            map = googleMap;
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(station.getPoint().first, station.getPoint().second))
                    .title(station.getStationTitle()));
        });
    }
}
