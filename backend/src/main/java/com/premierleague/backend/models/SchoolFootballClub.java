package com.premierleague.backend.models;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub {
    private String schoolBranch;
    private String schoolType;
    private String schoolStudentType;

    public SchoolFootballClub() {
        // Default Constructor
    }
    //constructor with arguments
    public SchoolFootballClub(String schoolBranch, String schoolType, String schoolStudentType) {
        this.schoolBranch = schoolBranch;
        this.schoolType = schoolType;
        this.schoolStudentType = schoolStudentType;
    }

    public SchoolFootballClub(int id,String name, String location, String numberOfMembers, String directorName, String contactNumber,
                              String email,int numberOfMatchesPlayed, int numberOfSeasonsPlayed, String schoolBranch,
                              String schoolType, String schoolStudentType) {
        super(id,name, location, numberOfMembers, directorName, contactNumber, email, numberOfMatchesPlayed,
                numberOfSeasonsPlayed);
        this.schoolBranch = schoolBranch;
        this.schoolType = schoolType;
        this.schoolStudentType = schoolStudentType;
    }
    //getters and setters
    public String getSchoolBranch() {
        return schoolBranch;
    }

    public void setSchoolBranch(String schoolBranch) {
        this.schoolBranch = schoolBranch;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchoolStudentType() {
        return schoolStudentType;
    }

    public void setSchoolStudentType(String schoolStudentType) {
        this.schoolStudentType = schoolStudentType;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolBranch, that.schoolBranch) &&
                Objects.equals(schoolType, that.schoolType) &&
                Objects.equals(schoolStudentType, that.schoolStudentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolBranch, schoolType, schoolStudentType);
    }

    @Override
    public String toString() {
        return "SchoolFootballClub{" +super.toString()+
                "schoolBranch='" + schoolBranch + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", schoolStudentType='" + schoolStudentType + '\'' +
                '}';
    }
}
