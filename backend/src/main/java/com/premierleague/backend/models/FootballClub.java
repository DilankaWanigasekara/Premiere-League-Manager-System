package com.premierleague.backend.models;

import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{
    private int wins= 0;
    private int draws= 0;
    private int defeats= 0;
    private int numberOfGoalsReceived= 0;
    private int numberOfGoalsScored= 0;
    private int currentPoints= 0;
    private int numberOfMatchesPlayed;
    private int numberOfSeasonsPlayed;

    public FootballClub() {
        // Default Constructor
    }

    //constructor with arguments
    public FootballClub(int id,String name, String location, String numberOfMembers, String directorName, String contactNumber,
                        String email,int numberOfMatchesPlayed, int numberOfSeasonsPlayed ) {
        super(id,name, location, numberOfMembers, directorName, contactNumber,email);
        this.numberOfMatchesPlayed=numberOfMatchesPlayed;
        this.numberOfSeasonsPlayed=numberOfSeasonsPlayed;


    }

    //getters and setters
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getNumberOfParticipatedEvents() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfParticipatedEvents(int numberOfParticipatedEvents) {
        this.numberOfMatchesPlayed = numberOfParticipatedEvents;
    }

    public int getNumberOfSeasonsPlayed() {
        return numberOfSeasonsPlayed;
    }

    public void setNumberOfSeasonsPlayed(int numberOfSeasonsPlayed) {
        this.numberOfSeasonsPlayed = numberOfSeasonsPlayed;
    }


    @Override
    public int compareTo(FootballClub footballClub2) {
        if (this.getCurrentPoints()- footballClub2.getCurrentPoints()==0){
            return this.getNumberOfGoalsScored()-footballClub2.getNumberOfGoalsScored();
        }
        else {
            return this.getCurrentPoints() - footballClub2.getCurrentPoints();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                numberOfGoalsReceived == that.numberOfGoalsReceived &&
                numberOfGoalsScored == that.numberOfGoalsScored &&
                currentPoints == that.currentPoints &&
                numberOfMatchesPlayed == that.numberOfMatchesPlayed &&
                numberOfSeasonsPlayed == that.numberOfSeasonsPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, currentPoints, numberOfMatchesPlayed, numberOfSeasonsPlayed);
    }

    @Override
    public String toString() {
        return "FootballClub{" +super.toString()+
                "wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", numberOfGoalsReceived=" + numberOfGoalsReceived +
                ", numberOfGoalsScored=" + numberOfGoalsScored +
                ", currentPoints=" + currentPoints +
                ", numberOfParticipatedEvents=" + numberOfMatchesPlayed +
                ", numberOfSeasonsPlayed=" + numberOfSeasonsPlayed +
                '}';
    }
}
