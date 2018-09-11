package com.example.irishka.timetable.ui.mainScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.ui.mainScreen.stations.view.StationsFragment;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;
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

        drawerResult = createDrawer();

    }

    private Drawer.Result createDrawer() {

        return new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.menu_timetable).withIcon(FontAwesome.Icon.faw_times).withIdentifier(1),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.menu_about).withIcon(FontAwesome.Icon.faw_question_circle).withIdentifier(2)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        FragmentManager fm = getSupportFragmentManager();
                        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

                        if (id == 1) {
                            if (fragment == null || fragment instanceof InfoFragment)
                                fragment = StationsFragment.newInstance();
                        } else if (id == 2) {
                            if (fragment == null || fragment instanceof StationsFragment)
                                fragment = InfoFragment.newInstance();
                        } else {
                            fragment = StationsFragment.newInstance();
                        }
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();
                    }
                })
                .build();
    }
}
