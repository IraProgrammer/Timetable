package com.example.irishka.timetable.ui.addTrip.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class AddTripFragment extends MvpAppCompatFragment implements AddTripView {

    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    @BindView(R.id.et_from)
    EditText fromEt;

    @BindView(R.id.et_to)
    EditText toEt;

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

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        dateBtn.setText(dateFormat.format(date));

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(date);
                dialog.setTargetFragment(AddTripFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        okBtn.setOnClickListener(view -> addTripPresenter.insertTrip(new Trip(fromEt.getText().toString(), toEt.getText().toString(), dateBtn.getText().toString())));

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
}
