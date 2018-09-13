package com.example.irishka.timetable.ui.myTrips.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irishka.timetable.R;
import com.example.irishka.timetable.domain.entities.Trip;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyTripsAdapter extends RecyclerView.Adapter<MyTripsAdapter.MyTripsViewHolder> {

    private List<Trip> trips = new ArrayList<>();

    @Inject
    public MyTripsAdapter() {
    }

    public void setTripsList(List<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyTripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyTripsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyTripsViewHolder holder, int position) {

        holder.bind(trips.get(position));

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    static class MyTripsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_from)
        TextView fromTv;

        @BindView(R.id.tv_to)
        TextView toTv;

        @BindView(R.id.tv_date)
        TextView dateTv;

        MyTripsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Trip trip) {

            fromTv.setText(itemView.getResources().getString(R.string.card_from, trip.getFrom()));

            toTv.setText(itemView.getResources().getString(R.string.card_to, trip.getTo()));

            dateTv.setText(itemView.getResources().getString(R.string.card_date, trip.getDate()));
        }
    }
}
