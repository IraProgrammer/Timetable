package com.example.irishka.timetable.ui.addTrip.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Trip;
import com.example.irishka.timetable.ui.addTrip.presenter.AddTripPresenter;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class AddTripFragment extends MvpAppCompatFragment implements AddTripView {

    @BindView(R.id.et_from)
    EditText fromEt;

    @BindView(R.id.et_to)
    EditText toEt;

    @BindView(R.id.et_date)
    EditText dateEt;

    @BindView(R.id.btn_ok)
    Button okBtn;

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
        View v = inflater.inflate(R.layout.test, container, false);
        ButterKnife.bind(this, v);

        okBtn.setOnClickListener(view -> addTripPresenter.insertTrip(new Trip(fromEt.getText().toString(), toEt.getText().toString(), dateEt.getText().toString())));

        return v;
    }

    @Override
    public void showToast() {
        Toast.makeText(getActivity(), "OK", Toast.LENGTH_LONG).show();
    }
}
