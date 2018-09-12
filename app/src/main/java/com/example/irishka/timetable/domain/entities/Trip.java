
package com.example.irishka.timetable.domain.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

public class Trip {

    public Trip(){
    }

    public Trip(String from, String to, String Date){
        this.from = from;
        this.to = to;
        this.date = date;
    }

    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String to;

    private String date;

}
