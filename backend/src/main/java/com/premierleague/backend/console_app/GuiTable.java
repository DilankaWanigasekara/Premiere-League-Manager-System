package com.premierleague.backend.console_app;

import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

    public class GuiTable  {
        private List<FootballClub> clubList;
        private List<Match> matchList;
        private Match match = new Match();
        private FxApplication fxApplication;
        private TableView<FootballClub> table = new TableView<>();



        public  void loadTable (List<FootballClub> clubList,List<Match> matchList) {
            Stage window = new Stage();
            window.setTitle("Teams Statistics");
            ObservableList<FootballClub> clubs = FXCollections.observableArrayList();

            TableColumn<FootballClub, Integer> column1 = new TableColumn<>("Club ID");
            column1.setMinWidth(50);
            column1.setCellValueFactory(new PropertyValueFactory<>("id"));
            column1.setSortable(false);
            TableColumn<FootballClub, String> column2 = new TableColumn<>("Club name");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("name"));
            column2.setSortable(false);

            TableColumn<FootballClub, Integer>column3 = new TableColumn<>("Current points");
            column3.setMinWidth(50);
            column3.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));

            //column3.setSortType(TableColumn.SortType.DESCENDING);


            TableColumn<FootballClub, Integer> column4 = new TableColumn<>("Number of wins");
            column4.setMinWidth(50);
            column4.setCellValueFactory(new PropertyValueFactory<>("wins"));

            TableColumn<FootballClub, Integer> column5 = new TableColumn<>("Number of defeats");
            column5.setMinWidth(50);
            column5.setCellValueFactory(new PropertyValueFactory<>("defeats"));
            column5.setSortable(false);
            TableColumn<FootballClub, Integer> column6 = new TableColumn<>("Number of draws");
            column6.setMinWidth(50);
            column6.setCellValueFactory(new PropertyValueFactory<>("draws"));
            column6.setSortable(false);

            TableColumn<FootballClub, Integer> column7 = new TableColumn<>("Number of goals scored ");
            column7.setMinWidth(50);
            column7.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

            TableColumn<FootballClub, Integer> column8 = new TableColumn<>("Number of goals received");
            column8.setMinWidth(50);
            column8.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));
            column8.setSortable(false);

            clubs.addAll(clubList);

            table.setItems(clubs);
            table.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7,column8);



            Button button1 = new Button("Generate random matches and add to the PLM");
            button1.setLayoutX(120);
            button1.setLayoutY(50);
            button1.setPrefWidth(300);
            button1.setStyle("-fx-background-color:lime");

            button1.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        button1.setStyle("-fx-background-color:#2ecc71");
                                        button1.setDisable(false);
                                        Calendar calendar = new GregorianCalendar(2020, 12, 10);
                                        Date date = new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
                                        match.setDate(date);
                                        Random random = new Random();      //instance of random class
                                        int random1 = clubList.size();
                                        //generate random values from 0-50
                                        int random2 = random.nextInt(random1);

                                        int num1 = 0;
                                        for (int i = 0; i < clubList.size(); i++) {
                                            if (clubList.get(i).getId() == random2) {
                                                num1 = i;
                                            }
                                        }
                                        System.out.println(num1);
                                        Random random3 = new Random();      //instance of random class
                                        int random4 = clubList.size();
                                        //generate random values from 0-50
                                        int random5 = random.nextInt(random4);
                                        int num2 = 0;
                                        while (true) {
                                            if (random5 != random2) {
                                                for (int i = 0; i < clubList.size(); i++) {
                                                    if (clubList.get(i).getId() == random5) {
                                                        num2 = (i);
                                                    }
                                                }
                                                break;
                                            } else {
                                                Random randomNum = new Random();      //instance of random class
                                                int rand = clubList.size();
                                                //generate random values from 0-50
                                                int randomNew = random.nextInt(rand);
                                                for (int i = 0; i < clubList.size(); i++) {
                                                    if (clubList.get(i).getId() == randomNew) {
                                                        num2 = (i);
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println(num2);
                                        FootballClub club1 = clubList.get(num1);
                                        FootballClub club2 = clubList.get(num2);

                                        Random random6 = new Random();      //instance of random class
                                        int random7 = 11;
                                        //generate random values from 0-50
                                        int random8 = random.nextInt(random7);


                                        Random random9 = new Random();      //instance of random class
                                        int random10 = 11;
                                        //generate random values from 0-50
                                        int random11 = random.nextInt(random10);
                                        club1.setNumberOfGoalsScored(club1.getNumberOfGoalsScored() + random8);
                                        club2.setNumberOfGoalsScored(club2.getNumberOfGoalsScored() + random11);

                                        club1.setNumberOfGoalsReceived(club1.getNumberOfGoalsReceived() + random8);
                                        club2.setNumberOfGoalsReceived(club2.getNumberOfGoalsReceived() + random11);
                                        if (random11 != random8) {
                                            if (random8 > random11) {
                                                club1.setWins(club1.getWins() + 1);
                                                club2.setDefeats(club2.getDefeats() + 1);
                                            } else if (random8 == random11) {
                                                club1.setDraws(club1.getDraws() + 1);
                                                club2.setDraws(club1.getDraws() + 1);

                                            } else {
                                                club2.setWins(club2.getWins() + 1);
                                                club1.setDefeats(club1.getDefeats() + 1);
                                            }
                                            club1.setCurrentPoints((club1.getWins() * 100) + (club1.getDraws() * 50));
                                            club2.setCurrentPoints((club2.getWins() * 100) + (club2.getDraws() * 50));

//                                    club2.setNumberOfGoalsScored((random11) + (club2.getNumberOfGoalsScored()));

                                            match.setTeam_1(club1);
                                            match.setTeam_2(club2);
                                            match.setGoalsTeam_1(random8);
                                            match.setGoalsTeam_2(random11);
                                        }
                                        matchList.add(match);
                                        table.refresh();
                                    }
                                }
            );
//        AnchorPane anchorPane;
//        Scene scene2=new Scene(anchorPane);
//        Button button2 = new Button("Played matches ascending order of date ");
//        button2.setOnAction(e ->window.setScene(scene2));
//        button2.setLayoutX(120);
//        button2.setLayoutY(10);
//        button2.setPrefWidth(300);
//        button2.setStyle("-fx-background-color:lime");
//
//        button2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                //button2.setStyle("-fx-background-color:#2ecc71");
//                fxApplication.loadMatches(matchList);
//
//            }});

            VBox vbox = new VBox(20);
            vbox.getChildren().addAll(table,button1);
            Scene scene = new Scene(vbox,880,500);
            window.setScene(scene);
            window.showAndWait();
        }


    }




