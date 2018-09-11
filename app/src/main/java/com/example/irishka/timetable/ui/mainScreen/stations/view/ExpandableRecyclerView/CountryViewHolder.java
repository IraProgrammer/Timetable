package com.example.irishka.timetable.ui.mainScreen.stations.view.ExpandableRecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.irishka.timetable.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class CountryViewHolder extends GroupViewHolder{

        private TextView genreTitle;

        public CountryViewHolder(View itemView) {
            super(itemView);
            genreTitle = itemView.findViewById(R.id.tv_country);
        }

        public void setGenreTitle(ExpandableGroup group) {
            genreTitle.setText(group.getTitle());
        }
}
