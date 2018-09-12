package com.example.irishka.timetable.ui.mainScreen.stations.view.ExpandableRecyclerView;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irishka.timetable.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class CountryViewHolder extends GroupViewHolder {

    private TextView genreTitle;

    private ImageView arrow;

    public CountryViewHolder(View itemView) {
        super(itemView);
        genreTitle = itemView.findViewById(R.id.tv_country);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_country_arrow);
    }

    public void setGenreTitle(ExpandableGroup group) {
        genreTitle.setText(group.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
