package com.example.irishka.timetable.ui.mainScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.irishka.timetable.R;
import com.example.irishka.timetable.ui.addTrip.view.AddTripFragment;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;
import com.example.irishka.timetable.ui.myTrips.view.MyTripsFragment;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Drawer.Result drawerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentManager fm = getSupportFragmentManager();

        StationsFragment stationsFragment = StationsFragment.newInstance();

        fm.beginTransaction()
                .add(R.id.fragment_container, stationsFragment)
                .commit();

        drawerResult = createDrawer();

    }

    private Drawer.Result createDrawer() {

        return new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.menu_timetable).withIcon(FontAwesome.Icon.faw_circle),
                        new PrimaryDrawerItem().withName(R.string.menu_add).withIcon(FontAwesome.Icon.faw_plus),
                        new PrimaryDrawerItem().withName(R.string.menu_myPlans).withIcon(FontAwesome.Icon.faw_heart),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.menu_about).withIcon(FontAwesome.Icon.faw_question_circle)
                )
                .withOnDrawerItemClickListener((parent, view, position, id, drawerItem) -> {

                    FragmentManager fm = getSupportFragmentManager();
                    Fragment fragment = fm.findFragmentById(R.id.fragment_container);

                    int posit = position;
                    long i = id;

                    if (position == 1) {
                        if (fragment == null || !(fragment instanceof StationsFragment))
                            fragment = StationsFragment.newInstance();
                    } else if (position == 2) {
                        if (fragment == null || !(fragment instanceof AddTripFragment))
                            fragment = AddTripFragment.newInstance();
                    } else if (position == 3) {
                        if (fragment == null || !(fragment instanceof MyTripsFragment))
                            fragment = MyTripsFragment.newInstance();
                    } else if (position == 5) {
                        if (fragment == null || !(fragment instanceof InfoFragment))
                            fragment = InfoFragment.newInstance();
                    }

                    if (fragment != null) {
                        FragmentTransaction ft = fm.beginTransaction();
//                        if (fragment instanceof StationsFragment) {
//                            ft.addToBackStack(null);
//                        }
                        ft.replace(R.id.fragment_container, fragment)
                                .commit();
                    }
                })
                .build();
    }
}
