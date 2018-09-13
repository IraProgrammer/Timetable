package com.example.irishka.timetable.ui.myTrips.view;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.ui.myTrips.presenter.MyTripsPresenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class MyTripsFragment extends MvpAppCompatFragment implements MyTripsView {

    @Inject
    Provider<MyTripsPresenter> myTripsPresenterProvider;

    @InjectPresenter
    MyTripsPresenter myTripsPresenter;

    @ProvidePresenter
    MyTripsPresenter providePresenter() {
        return myTripsPresenterProvider.get();
    }

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.btn_home)
    ImageButton homeBtn;

    @BindView(R.id.rv_myTrips)
    RecyclerView myTripsRv;

    @Inject
    MyTripsAdapter myTripsAdapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    public static MyTripsFragment newInstance() {
        return new MyTripsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mytrips, container, false);
        ButterKnife.bind(this, v);

        toolbarTitle.setText("Все поездки");

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        myTripsRv.setLayoutManager(linearLayoutManager);

        myTripsRv.setAdapter(myTripsAdapter);

        return v;
    }

    @Override
    public void showMyTrips(List<Trip> trips) {
        myTripsAdapter.setTripsList(trips);
    }
}
