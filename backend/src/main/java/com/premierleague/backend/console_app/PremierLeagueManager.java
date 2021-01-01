package com.premierleague.backend.console_app;

import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;
import com.premierleague.backend.models.SportsClub;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    private List<FootballClub> clubList = new ArrayList<>();   // this stores all the clubs
    private List<Match> matchList = new ArrayList<>();         // this stores all the matches
    Scanner sc = new Scanner(System.in);
    String file = "PremiereLeagueManager.txt";



    // the default constructor loads all the teams and matches from the text-file into the program
    public PremierLeagueManager(){
        try {

            File file1 = new File(file);
            if(file1.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                clubList = (List<FootballClub>) objectInputStream.readObject();
                matchList = (List<Match>) objectInputStream.readObject();

                objectInputStream.close();
                fileInputStream.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error loading text file");
            System.out.println("Exiting....");
            System.exit(0);
        }


    }

    // this method is used to create a club
    @Override
    public void createClub() {
        int id = clubList.size() + 1;   // id will be auto generated depending on the size of the clubList
        String name;
        String location;
        String members;
        String clubDirector;
        String contactNumber;
        String directorEmail;
        int matchesPlayed;
        int seasonsPlayed;
        String clubType;
        String branchName;
        String status;
        String schoolType;
        String uniType;


        while (true) {
            System.out.println("Enter the name of the club:");
            name = sc.nextLine();
            if (!Validation.onlyString(name)) {
                System.out.println("name should not include integers!try again ");
            } else {
                break;
            }
        }

        // checks if a club already by that name, if so the user will be directed to the menu
        for (FootballClub club : clubList) {
            if (club.getName().equals(name)) {
                System.out.println("Already there is a club from entered name..");
                return;
            }
        }

        System.out.println("Enter the location of the club:");
        location = sc.nextLine();

        while (true) {
            System.out.println("Enter the number of members of the club:");
            members = sc.nextLine();
            if (!Validation.onlyInt(members)) {
                System.out.println("number of members should not include characters!! Please re-enter!!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter director name of the club: ");
            clubDirector = sc.nextLine();
            if (!Validation.onlyString(clubDirector)) {
                System.out.println("name should only include characters!! ");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter the contact number of the director:");
            contactNumber = sc.nextLine();
            if (!Validation.onlyInt(contactNumber)) {
                System.out.println("contact number should not include characters!! please try again!");
            } else if (contactNumber.length() < 10) {
                System.out.println("contact number is not valid!! Please re-enter again! ");
            } else {
                break;
            }
        }

        System.out.println("Enter the Email of the director:");
        directorEmail = sc.nextLine();

        while (true) {
            try {
                System.out.println("Enter number of football matches club has played:");
                matchesPlayed = sc.nextInt();
                System.out.println("Enter the number of seasons club has played :");
                seasonsPlayed = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("should include only integers!");
                sc.nextLine();
            }
        }

        SportsClub footballClub = new FootballClub(id, name, location, members, clubDirector, contactNumber, directorEmail, matchesPlayed, seasonsPlayed);
        clubList.add((FootballClub) footballClub);
        System.out.println(name+ " club added to the Premier League successfully!!!");
        sc.nextLine();
    }

    // method to delete an existing cub by its id
    @Override
    public void deleteClub(int id) {
        for (FootballClub fc : clubList) {
            if (fc.getId() == id) {
                clubList.remove(fc);
                System.out.println("'" + fc.getName() + "' Football club removed from the premier league successfully ");
                return;
            }

        }
        System.out.println("sorry there is not any football club from entered id!Try again");
    }





    // method to display the statistics of any given club
    @Override
    public void displayClubStatistics(int id) {
        for (FootballClub club:clubList) {
            if (club.getId() == id) {
                System.out.println("Club name: " + club.getName());
                System.out.println("Number of wins: " + club.getWins());
                System.out.println("Number of defeats: " + club.getDefeats());
                System.out.println("Number of draws: " + club.getDraws());
                System.out.println("Current points: " + club.getCurrentPoints());
                System.out.println("Number of goals received: " + club.getNumberOfGoalsReceived());
                System.out.println("Number of goals scored: " + club.getNumberOfGoalsScored());
                System.out.println("Number of matches played: " + club.getNumberOfParticipatedEvents());
                System.out.println("Number of seasons played: " + club.getNumberOfSeasonsPlayed());
                return;
            }
        }
        System.out.println("sorry there is not any football club from entered id!");
    }




    // Source : https://www.logicbig.com/how-to/code-snippets/jcode-java-cmd-command-line-table.html
    // This creates a table showing all team statistics in the premiere league
    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(clubList, Collections.reverseOrder());
        Table table = new Table();
        table.setShowVerticalLines(true);
        table.setHeaders("Club Id","Club name"," Current points" , "Number of wins" ," Number of defeats "," Number of draws"," Number of goals received","Number of goals scored ");//optional - if not used then there will be no header and horizontal lines
        for (FootballClub clubTable: clubList){
            table.addRow(String.valueOf(clubTable.getId()),clubTable.getName(),String.valueOf(clubTable.getCurrentPoints()),String.valueOf(clubTable.getWins()),String.valueOf( clubTable.getDefeats()),String.valueOf(clubTable.getDraws()), String.valueOf(clubTable.getNumberOfGoalsReceived()),String.valueOf( clubTable.getNumberOfGoalsScored()));
        }
        table.print();
    }

    @Override //allow user to add a played match in premier league
    public void addPlayedMatch(int team1, int team2, int goalsTeam1, int goalsTeam2, Date playedDate) {
        int id = clubList.size() + 1;
        int club_01_index = -1;
        int club_02_index = -1;

        // loading team 01 and 02
        for (int x =0; x<clubList.size();x++){
            if (clubList.get(x).getId() == team1){
                club_01_index = x;
            }
            if (clubList.get(x).getId() == team2){
                club_02_index = x;
            }
        }

        if (club_01_index==-1 || club_02_index==-1){
            System.out.println("------------------------------------------------------");
            System.out.println("Non-Existing club id entered!!! Please try again !!!");
            return;
        }

        FootballClub club01 = clubList.get(club_01_index);
        FootballClub club02 = clubList.get(club_02_index);

        // adding the goals scored
        club01.setNumberOfGoalsScored(club01.getNumberOfGoalsScored() + goalsTeam1);
        club02.setNumberOfGoalsScored(club02.getNumberOfGoalsScored() + goalsTeam2);

        // adding goals received
        club01.setNumberOfGoalsReceived(club01.getNumberOfGoalsReceived() + goalsTeam2);
        club02.setNumberOfGoalsReceived(club02.getNumberOfGoalsReceived() + goalsTeam1);

        // adding wins and losses
        if (goalsTeam1>goalsTeam2){
            club01.setWins(club01.getWins() + 1);
            club02.setDefeats(club02.getDefeats() + 1);
        } else if (goalsTeam1==goalsTeam2){
            club01.setDraws(club01.getDraws() + 1);
            club02.setDraws(club02.getDraws() + 1);
        }else{
            club02.setWins(club02.getWins() + 1);
            club01.setDefeats(club01.getDefeats() + 1);
        }

        // calculate new points
        // win = 100 points
        // draw = 50 points
        club01.setCurrentPoints((club01.getWins()*100) + (club01.getDraws() * 50));
        club02.setCurrentPoints((club02.getWins()*100) + (club02.getDraws() * 50));

        // save the updated clubs back to list
        clubList.set(club_01_index, club01);
        clubList.set(club_02_index, club02);

        // create match
        Match match = new Match(id,club01, club02, goalsTeam1, goalsTeam2, playedDate);

        // add match to list
        matchList.add(match);
        System.out.println("Match added successfully!");
        return;
    }

    @Override
    public void saveAndExit(){ // method to save all entered data and exit
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            System.out.println("Saving your data...");

            objectOutputStream.writeObject(clubList);
            objectOutputStream.writeObject(matchList);


            System.out.println("Thank you");
            System.exit(0);
        }catch (Exception e){
            System.out.println(e.getMessage() + ": Error is saving to file");
        }
    }

    @Override //method to open client page
    public void openGUI() {
//        try {
//            Desktop desktop = java.awt.Desktop.getDesktop();
//            URI oURL = new URI("http://localhost:3000/");
//            desktop.browse(oURL);
//        } catch (Exception e) {
//            System.out.println(e.getMessage()+": Error in loading client page...");
//        }
        GuiTable gui=new GuiTable();
        FxApplication fxApplication=new FxApplication(clubList, matchList);

        gui.loadTable(clubList,matchList);

    }
    public void GuiMatch(){
        FxApplication fxApplication=new FxApplication(clubList, matchList);
        fxApplication.loadMatches(matchList);

    }
}

