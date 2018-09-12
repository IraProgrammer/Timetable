package com.example.irishka.timetable.ui.mainScreen.stations.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;
import com.example.irishka.timetable.ui.description.view.DescriptionFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.presenter.StationsPresenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class StationsFragment extends MvpAppCompatFragment implements StationsView, StationsAdapter.OnItemClickListener {

    @BindView(R.id.stationsRecyclerView)
    RecyclerView recyclerView;

    @Inject
    Provider<StationsPresenter> stationsPresenterProvider;

    @InjectPresenter
    StationsPresenter stationsPresenter;

    @ProvidePresenter
    StationsPresenter providePresenter() {
        return stationsPresenterProvider.get();
    }

 //   @Inject
    StationsAdapter stationsAdapter;

//    @Inject
//    LinearLayoutManager linearLayoutManager;

    public static StationsFragment newInstance() {
        return new StationsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stations, container, false);
        ButterKnife.bind(this, v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return v;
    }

    @Override
    public void showStations(List<Country> countries) {
        stationsAdapter = new StationsAdapter(countries, this);
        recyclerView.setAdapter(stationsAdapter);
    }

    @Override
    public void onItemClick(Station station) {
        DescriptionFragment descriptionFragment = DescriptionFragment.newInstance(station);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, descriptionFragment);
        fragmentTransaction.addToBackStack(this.toString());
        fragmentTransaction.commit();
    }
}
