package com.premierleague.backend.models;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(){
        //default constructor
    }

    //constructor with arguments
    public Date(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }


    //getters and setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}

