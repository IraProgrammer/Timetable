package com.example.irishka.timetable.ui.mainScreen.stations.view.ExpandableRecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Station;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class StationViewHolder extends ChildViewHolder {

    private TextView artistName;

    public StationViewHolder(View itemView) {
        super(itemView);
        artistName = itemView.findViewById(R.id.tv_country);
    }

    public void onBind(Station station) {
        artistName.setText(station.getStationTitle());
    }
}
