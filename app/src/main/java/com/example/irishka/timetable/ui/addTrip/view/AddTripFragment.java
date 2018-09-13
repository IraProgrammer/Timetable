package com.example.irishka.timetable.ui.addTrip.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.ui.addTrip.presenter.AddTripPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class AddTripFragment extends MvpAppCompatFragment implements AddTripView {

    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    Map<String, List<String>> fromMap;

    Map<String, List<String>> toMap;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.btn_home)
    ImageButton homeBtn;

    @BindView(R.id.sp_city_from)
    Spinner cityFromSpin;

    @BindView(R.id.sp_station_from)
    Spinner stationFromSpin;

    @BindView(R.id.sp_city_to)
    Spinner cityToSpin;

    @BindView(R.id.sp_station_to)
    Spinner stationToSpin;

    @BindView(R.id.btn_date)
    Button dateBtn;

    @BindView(R.id.btn_ok)
    Button okBtn;

    Date date = new Date();

    @Inject
    Provider<AddTripPresenter> addTripPresenterProvider;

    @InjectPresenter
    AddTripPresenter addTripPresenter;

    @ProvidePresenter
    AddTripPresenter providePresenter() {
        return addTripPresenterProvider.get();
    }

    public static AddTripFragment newInstance() {
        return new AddTripFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_addtrip, container, false);
        ButterKnife.bind(this, v);

        toolbarTitle.setText("Новая поездка");

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateBtn.setText(dateFormat.format(date));

        cityFromSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                refreshFromStations(cityFromSpin.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cityToSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                refreshToStations(cityToSpin.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(date);
                dialog.setTargetFragment(AddTripFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        okBtn.setOnClickListener(view -> {
            String from = cityFromSpin.getItemAtPosition(cityFromSpin.getSelectedItemPosition()).toString().concat(", ").concat(stationFromSpin.getItemAtPosition(stationFromSpin.getSelectedItemPosition()).toString());
            String to = cityToSpin.getItemAtPosition(cityToSpin.getSelectedItemPosition()).toString().concat(", ").concat(stationToSpin.getItemAtPosition(stationToSpin.getSelectedItemPosition()).toString());

            addTripPresenter.insertTrip(new Trip(from, to, dateBtn.getText().toString()));
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            this.date = date;
            dateBtn.setText(dateFormat.format(date));
        }
    }

    @Override
    public void showToast() {
        Toast.makeText(getActivity(), "Поездка успешно добавлена", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setFromMap(Map<String, List<String>> fromMap) {

        this.fromMap = fromMap;

        Set<String> citiesSet = fromMap.keySet();

        List<String> cities = new ArrayList<>(citiesSet);

        Collections.sort(cities);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, (ArrayList) cities);
        cityFromSpin.setAdapter(cityAdapter);

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, fromMap.get(cities.get(0)));
        stationFromSpin.setAdapter(stationAdapter);

    }

    @Override
    public void setToMap(Map<String, List<String>> toMap) {

        this.toMap = toMap;

        Set<String> citiesSet = toMap.keySet();

        List<String> cities = new ArrayList<>(citiesSet);

        Collections.sort(cities);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, cities);
        cityToSpin.setAdapter(cityAdapter);

        ArrayAdapter<String> stationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, toMap.get(cities.get(1)));
        stationToSpin.setAdapter(stationAdapter);

        cityToSpin.setSelection(1);

    }

    private void refreshFromStations(String item) {
        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, fromMap.get(item));
        stationFromSpin.setAdapter(stationAdapter);
    }

    private void refreshToStations(String item) {
        ArrayAdapter<String> stationAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, toMap.get(item));
        stationToSpin.setAdapter(stationAdapter);
    }
}
