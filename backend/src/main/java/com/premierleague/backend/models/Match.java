package com.premierleague.backend.models;

import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {
    private FootballClub team_1;
    private FootballClub team_2;
    private int goalsTeam_1;
    private int goalsTeam_2;
    private Date date;

    public Match(){
        //default constructor
    }

    //constructor with arguments
    public Match(FootballClub team_1,FootballClub team_2,int goalsTeam_1,int goalsTeam_2,Date date){
        this.team_1=team_1;
        this.team_2=team_2;
        this.goalsTeam_1=goalsTeam_1;
        this.goalsTeam_2=goalsTeam_2;
        this.date=date;
    }

    //getters and setters
    public FootballClub getTeam_1() {
        return team_1;
    }

    public void setTeam_1(FootballClub team_1) {
        this.team_1 = team_1;
    }

    public FootballClub getTeam_2() {
        return team_2;
    }

    public void setTeam_2(FootballClub team_2) {
        this.team_2 = team_2;
    }

    public int getGoalsTeam_1() {
        return goalsTeam_1;
    }

    public void setGoalsTeam_1(int goalsTeam_1) {
        this.goalsTeam_1 = goalsTeam_1;
    }

    public int getGoalsTeam_2() {
        return goalsTeam_2;
    }

    public void setGoalsTeam_2(int goalsTeam_2) {
        this.goalsTeam_2 = goalsTeam_2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return goalsTeam_1 == match.goalsTeam_1 &&
                goalsTeam_2 == match.goalsTeam_2 &&
                Objects.equals(team_1, match.team_1) &&
                Objects.equals(team_2, match.team_2) &&
                Objects.equals(date, match.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team_1, team_2, goalsTeam_1, goalsTeam_2, date);
    }

    @Override
    public String toString() {
        return "Match{" +
                "team_1=" + team_1 +
                ", team_2=" + team_2 +
                ", goalsTeam_1=" + goalsTeam_1 +
                ", goalsTeam_2=" + goalsTeam_2 +
                ", date=" + date +
                '}';
    }


}