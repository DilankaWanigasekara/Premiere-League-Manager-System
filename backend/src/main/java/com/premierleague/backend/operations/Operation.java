package com.premierleague.backend.operations;

import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
;

public class Operation {

    private List<FootballClub> clubList;
    private List<Match> matchList;
    private Match match = new Match();
    Date date=new Date();
    String file = "PremiereLeagueManager.txt";

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
        System.out.println(clubList);

        return clubList;
    }

    public Match generateMatch() throws IOException {
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

        System.out.println(clubList);
        System.out.println(matchList);


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

            while (randomClubIndex02 == randomClubIndex01) {
                randomClubIndex02 = randomNumber(clubList.size());
            }

            club2=clubList.get(randomClubIndex02);


            System.out.println(club1);
            System.out.println(club2);


            randomGoalsScored01 = randomNumber(30);
            System.out.println(randomGoalsScored01);

            randomGoalsScored02 = randomNumber(30);
            System.out.println(randomGoalsScored02);

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
        String file = "PremiereLeagueManager.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(clubList);
        objectOutputStream.writeObject(matchList);


        return match;


    }
    public List<Match> getMatches(){
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

        return matchList;
    }
    public List<Match> getPlayedMatches(Date date){
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
        List<Match> list=new ArrayList<>();
        for (int i=0;i<matchList.size();i++){
            if(matchList.get(i).getDate().equals(date)){
                list.add(matchList.get(i));
            }
        }
        return list;

    }
    public int randomNumber(int upperBound){

        Random random = new Random();      //instance of random class

        //generate random values from 0-number of clubs
        int randomNum = random.nextInt(upperBound);
        System.out.println("random number: " + randomNum);
        return randomNum;
    }

}
