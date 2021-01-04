package com.premierleague.backend.operations;

import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Operation {

    private List<FootballClub> clubList;
    private List<Match> matchList;
    private Match match = new Match();
    Date date=new Date();
    String file = "PremiereLeagueManager.txt";

    // method to read teams from text file and return the list of teams
    public List<FootballClub> getTeams() {

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            if (fileInputStream.available()>0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                clubList = (List<FootballClub>) objectInputStream.readObject();
                matchList = (List<Match>) objectInputStream.readObject();
                objectInputStream.close();
            }

            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error loading text file");
            e.printStackTrace();
        }
        return clubList;
    }

    // method to generate a new random match, and return the newly create match
    public Match generateMatch() throws IOException {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);

            // read all existing matches and teams from the textfile
            if (fileInputStream.available()>0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                clubList = (List<FootballClub>) objectInputStream.readObject();
                matchList = (List<Match>) objectInputStream.readObject();
                objectInputStream.close();
            }

            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error loading text file");
            e.printStackTrace();
        }

        FootballClub club1 = null;
        FootballClub club2=null;
        int randomClubIndex01;
        int randomClubIndex02;
        int randomGoalsScored01;
        int randomGoalsScored02;

        if (clubList.size()>1){
            date = new Date(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());


            randomClubIndex01 = randomNumber(clubList.size());
            club1=clubList.get(randomClubIndex01);


            randomClubIndex02 = randomNumber(clubList.size());

            // checks if both the clubs selected for match are same
            while (randomClubIndex02 == randomClubIndex01) {
                randomClubIndex02 = randomNumber(clubList.size());
            }

            club2=clubList.get(randomClubIndex02);

            // assumed the number of goals a team can play is between 0 and 10
            // goals scored is randomly generated between 0 and 10
            randomGoalsScored01 = randomNumber(10);
            randomGoalsScored02 = randomNumber(10);


            club1.setNumberOfGoalsScored(club1.getNumberOfGoalsScored() + randomGoalsScored01);
            club2.setNumberOfGoalsScored(club2.getNumberOfGoalsScored() + randomGoalsScored02);

            club1.setNumberOfGoalsReceived(club1.getNumberOfGoalsReceived() + randomGoalsScored01);
            club2.setNumberOfGoalsReceived(club2.getNumberOfGoalsReceived() + randomGoalsScored02);


            if (randomGoalsScored02 != randomGoalsScored01) {
                if (randomGoalsScored01 > randomGoalsScored02) {
                    club1.setWins(club1.getWins() + 1);
                    club2.setDefeats(club2.getDefeats() + 1);
                } else if (randomGoalsScored01 == randomGoalsScored02) {
                    club1.setDraws(club1.getDraws() + 1);
                    club2.setDraws(club1.getDraws() + 1);

                } else {
                    club2.setWins(club2.getWins() + 1);
                    club1.setDefeats(club1.getDefeats() + 1);
                }
            }

            // calculating the current points depending on the status of the match
            // assumed 1 win = 100 points, 1 draw = 50 points, 1 lose = 0 points
            club1.setCurrentPoints((club1.getWins() * 100) + (club1.getDraws() * 50));
            club2.setCurrentPoints((club2.getWins() * 100) + (club2.getDraws() * 50));

}
        else {
            throw new IllegalArgumentException("Sorry!! Not enough teams for the process ...");
        }

        int id = matchList.size() + 1;
        clubList.set(randomClubIndex01, club1);
        clubList.set(randomClubIndex02, club2);

        Match match=new Match(id, club1,club2,randomGoalsScored01,randomGoalsScored02,date);
        matchList.add(match);

        // writing the newly generated match and the new team scores to text file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(clubList);
        objectOutputStream.writeObject(matchList);

        return match;
    }

    // read all matches and return the list of matches
    public List<Match> getMatches(){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            // read matches from text file
            if (fileInputStream.available()>0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                clubList = (List<FootballClub>) objectInputStream.readObject();
                matchList = (List<Match>) objectInputStream.readObject();
                objectInputStream.close();
            }

            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error loading text file");
            e.printStackTrace();
        }
        return matchList;
    }

    // returns all the matches played on a particular date
    public List<Match> getPlayedMatches(Date date){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            // read the matches from text file
            if (fileInputStream.available()>0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                clubList = (List<FootballClub>) objectInputStream.readObject();
                matchList = (List<Match>) objectInputStream.readObject();
                objectInputStream.close();
            }
            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error loading text file");
            e.printStackTrace();
        }
        List<Match> list=new ArrayList<>();

        // checks for matches played on that give data
        for (int i=0;i<matchList.size();i++){
            if(matchList.get(i).getDate().equals(date)){
                list.add(matchList.get(i));
            }
        }
        return list;
    }

    // generates a random whole number between 0 and the provided number
    public int randomNumber(int upperBound){
        Random random = new Random();
        //generate random values from 0-number of clubs
        int randomNum = random.nextInt(upperBound);
        return randomNum;
    }

}
