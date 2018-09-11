package com.example.irishka.timetable.domain.entities;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Country extends ExpandableGroup<Station> {

    public Country(String title, List<Station> items) {
        super(title, items);
    }

}
