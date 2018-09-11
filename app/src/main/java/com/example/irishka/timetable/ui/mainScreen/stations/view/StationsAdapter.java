package com.example.irishka.timetable.ui.mainScreen.stations.view;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Station;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.StationsViewHolder> {

    private List<Pair<String, List<Station>>> stations = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    @Inject
    public StationsAdapter() {
    }

    public interface OnItemClickListener {
        void onItemClick();
    }

    public void setList(List<Pair<String, List<Station>>> stations) {
        this.stations.addAll(stations);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StationsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StationsViewHolder holder, int position) {

        holder.bind(stations.get(position));

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    static class StationsViewHolder extends RecyclerView.ViewHolder {

        private OnItemClickListener onItemClickListener;

        @BindView(R.id.tv_country)
        TextView countryTv;

        @BindView(R.id.listview_stations)
        ListView listView;

        @BindView(R.id.linlayout_item)
        LinearLayout linearLayout;

        StationsViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
        }

        void bind(Pair<String, List<Station>> item) {

            countryTv.setText(item.first);

            String[] stationNames = new String[item.second.size()];

            for (int i = 0; i < item.second.size(); i++) {
                stationNames[i] = item.second.get(i).getStationTitle();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(itemView.getContext(),
                    android.R.layout.simple_list_item_1, stationNames);

            // присваиваем адаптер списку
            listView.setAdapter(adapter);

//            itemView.setOnClickListener(view -> {
//
//                Toast.makeText(itemView.getContext(), item.first, Toast.LENGTH_LONG).show();
//                Toast.makeText(itemView.getContext(), String.valueOf(listView.getAdapter().getCount()), Toast.LENGTH_LONG).show();
//
//                if (!expandableLinearLayout.isExpanded()) {
//                    expandableLinearLayout.expand();
//                } else {
//                    expandableLinearLayout.collapse();
//                }
//
//                //  expandableLinearLayout.setExpanded(!expandableLinearLayout.isExpanded());
//            });
        }
    }
}
