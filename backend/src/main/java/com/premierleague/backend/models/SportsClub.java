package com.premierleague.backend.models;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private int id;
    private String name;
    private String location;
    private String numberOfMembers;
    private String directorName;
    private String contactNumber;
    private String email;

    public SportsClub(){
        //default constructor
    }

    //constructor with arguments
    public SportsClub(int id,String name,String location,String numberOfMembers,String directorName,
                      String contactNumber,String email ){
        super();
        this.id=id;
        this.name=name;
        this.location=location;
        this.numberOfMembers=numberOfMembers;
        this.directorName=directorName;
        this.contactNumber=contactNumber;
        this.email=email;


    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location) &&
                Objects.equals(numberOfMembers, that.numberOfMembers) &&
                Objects.equals(directorName, that.directorName) &&
                Objects.equals(contactNumber, that.contactNumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, numberOfMembers, directorName, contactNumber, email);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", numberOfMembers='" + numberOfMembers + '\'' +
                ", directorName='" + directorName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}