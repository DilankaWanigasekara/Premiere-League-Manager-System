package com.premierleague.backend.models;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {

    private String uniType;

    public UniversityFootballClub() {
        // Default Constructor
    }

    //constructor with arguments
    public UniversityFootballClub(int id,String name, String location, String numberOfMembers, String directorName,
                                  String contactNumber, String email,  int numberOfMatchesPlayed,
                                  int numberOfSeasonsPlayed, String uniType) {
        super(id,name, location, numberOfMembers, directorName, contactNumber, email,numberOfMatchesPlayed,
                numberOfSeasonsPlayed);
        this.uniType = uniType;
    }


    //getters and setters
    public String getUniType() {
        return uniType;
    }

    public void setUniType(String uniType) {
        this.uniType = uniType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(uniType, that.uniType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uniType);
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +super.toString()+
                "uniType='" + uniType + '\'' +
                '}';
    }
}