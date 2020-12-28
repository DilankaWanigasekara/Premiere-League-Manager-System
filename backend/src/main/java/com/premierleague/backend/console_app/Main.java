package com.premierleague.backend.console_app;

import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.Match;

import javafx.application.Application;
import javafx.stage.Stage;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main extends Application {
    private Scanner sc = new Scanner(System.in);
    private PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    private Match match=new Match();
    private Validation validation = new Validation();



    public static void main(String[] args) {launch();}
    @Override
    public void start(Stage primaryStage) throws Exception{

        Main main = new Main();
        String equalsLine = "======================================================";
        String minusLine = "------------------------------------------------------";

        System.out.println(equalsLine);
        System.out.println("         Welcome to Premiere League Manager           ");
        System.out.println(equalsLine);


        while(true) { //let the user select the option
            System.out.println(equalsLine);
            System.out.println("                        MENU                          ");
            System.out.println(equalsLine);
            System.out.println("1 - Add Team\n" +
                    "2 - Delete Team\n" +
                    "3 - Display Statistics of a Team\n" +
                    "4 - Display Premiere League Table\n" +
                    "5 - Add Match\n" +
                    "6 - Open GUI\n" +
                    "7 - Played matches\n" +
                    "8 - Save and exit");
            System.out.println(minusLine);
            System.out.println("Enter Option: ");
            String userInput= main.sc.nextLine();




            switch (userInput) {
                case "1":
                    main.premierLeagueManager.createClub();
                    break;
                case "2":
                    main.delete();
                    main.sc.nextLine();
                    break;
                case "3":
                    main.displayStatistics();
                    main.sc.nextLine();
                    break;
                case "4":
                    main.premierLeagueManager.displayPremierLeagueTable();
                    break;
                case "5":
                    main.addMatch();
                    break;
                case "6":
                    main.premierLeagueManager.openGUI();
                    break;
                case "7":
                    //main.premierLeagueManager.GuiMatch();
                    break;
                case "8" :
                    main.premierLeagueManager.saveAndExit();
                    break;
                default:
                    System.out.println("The option is invalid!! Please try again!!!! ");
                    break;

            }
        }
    }



    public void displayStatistics(){
        System.out.println("Enter Id of the club for check statistics:");
        int id =sc.nextInt();
        premierLeagueManager.displayClubStatistics(id);
    }

    public void delete() {
        System.out.println("Enter the club Id want to delete");
        int clubId = sc.nextInt();
        premierLeagueManager.deleteClub(clubId);
    }
    public void addMatch() {  //let the user to add the  played matches to premier league manager
        int teamOne;
        int teamTwo;
        int goalsTeamOne;
        int goalsTeamTwo;
        Date date;

        while(true) {
            try {
                System.out.println("Enter the two teams played in the match");
                System.out.println("Enter team one Id");
                teamOne = sc.nextInt();

                System.out.println("Enter team two Id");
                teamTwo = sc.nextInt();

                if (teamOne==teamTwo) {
                    System.out.println("Same id detected for both teams!! Please check and re-enter the correct ids!! ");
                    sc.nextLine();
                    return;
                }

            } catch (Exception e) {
                System.out.println("Invalid id detected!! Please try again!!!");
                sc.nextLine();
                return;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Enter the goals scored team one");
                goalsTeamOne = sc.nextInt();
                System.out.println("Enter the goals scored team two");
                goalsTeamTwo = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Inputs not valid!!! Please re-enter");
                sc.nextLine();
            }
        }

        while (true) {

            System.out.println("Enter the date match held in format (dd-mm-yyyy)");
            String dateArr[] = sc.nextLine().split("-");
            if(Validation.checkDate(dateArr)){
                date = new Date(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
                premierLeagueManager.addPlayedMatch(teamOne, teamTwo, goalsTeamOne, goalsTeamTwo, date);
                break;
            }else {
                System.out.println("Invalid date format!!!");
            }

        }

    }
}

