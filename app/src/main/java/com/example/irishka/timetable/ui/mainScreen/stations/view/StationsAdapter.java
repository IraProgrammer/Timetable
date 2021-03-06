package com.example.irishka.timetable.ui.mainScreen.stations.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Country;
import com.example.irishka.timetable.domain.entities.Station;
import com.example.irishka.timetable.ui.mainScreen.stations.view.ExpandableRecyclerView.CountryViewHolder;
import com.example.irishka.timetable.ui.mainScreen.stations.view.ExpandableRecyclerView.StationViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class StationsAdapter extends ExpandableRecyclerViewAdapter<CountryViewHolder, StationViewHolder> {

    OnItemClickListener onItemClickListener;

    StationsAdapter(List<? extends ExpandableGroup> groups, OnItemClickListener onItemClickListener) {
        super(groups);
        this.onItemClickListener = onItemClickListener;
    }

     public interface OnItemClickListener{
        void onItemClick(Station station);
     }

    @Override
    public CountryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public StationViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.station_item, parent, false);
        return new StationViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(StationViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex) {
        final Station artist = ((Country) group).getItems().get(childIndex);
        holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(artist));
        holder.onBind(artist);
    }

    @Override
    public void onBindGroupViewHolder(CountryViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setGenreTitle(group);
    }

//    private OnItemClickListener onItemClickListener;
//
//    public interface OnItemClickListener {
//        void onItemClick();
//    }
//
//    public void setList(List<Pair<String, List<Station>>> stations) {
//        this.stations.addAll(stations);
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public StationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new StationsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false), onItemClickListener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull StationsViewHolder holder, int position) {
//
//        holder.bind(stations.get(position));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return stations.size();
//    }
//
//    static class StationsViewHolder extends RecyclerView.ViewHolder {
//
//        private OnItemClickListener onItemClickListener;
//
//        @BindView(R.id.tv_country)
//        TextView countryTv;
//
//        @BindView(R.id.listview_stations)
//        ListView listView;
//
//        @BindView(R.id.linlayout_item)
//        LinearLayout linearLayout;
//
//        StationsViewHolder(View itemView, OnItemClickListener onItemClickListener) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            this.onItemClickListener = onItemClickListener;
//        }
//
//        void bind(Pair<String, List<Station>> item) {
//
//            countryTv.setText(item.first);
//
//            String[] stationNames = new String[item.second.size()];
//
//            for (int i = 0; i < item.second.size(); i++) {
//                stationNames[i] = item.second.get(i).getStationTitle();
//            }
//
//            ArrayAdapter<String> adapter = new ArrayAdapter<>(itemView.getContext(),
//                    android.R.layout.simple_list_item_1, stationNames);
//
//            // присваиваем адаптер списку
//            listView.setAdapter(adapter);
//
////            itemView.setOnClickListener(view -> {
////
////                Toast.makeText(itemView.getContext(), item.first, Toast.LENGTH_LONG).show();
////                Toast.makeText(itemView.getContext(), String.valueOf(listView.getAdapter().getCount()), Toast.LENGTH_LONG).show();
////
////                if (!expandableLinearLayout.isExpanded()) {
////                    expandableLinearLayout.expand();
////                } else {
////                    expandableLinearLayout.collapse();
////                }
////
////                //  expandableLinearLayout.setExpanded(!expandableLinearLayout.isExpanded());
////            });
//        }
//    }
}
