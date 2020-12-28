package com.premierleague.backend.console_app;


    import com.premierleague.backend.models.Date;
    import com.premierleague.backend.models.FootballClub;
    import com.premierleague.backend.models.Match;
    import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

    public class FxApplication {
        private TableView<Match> table = new TableView<>();
        PremierLeagueManager premierLeagueManager=new PremierLeagueManager();
        Match match=new Match();
        List<FootballClub> clubList;
        List<Match> matchList;

        public FxApplication(List<FootballClub> clubList, List<Match> matchList) {
            this.clubList = clubList;
            this.matchList = matchList;

            // load a general gui
            // has 2 buttons/tabs
            //1: load trams
            loadTeams();
            //2: load matches

        }
        public void gui(){
            Stage window = new Stage();
//    Scene scene1=new Scene();
//    Scene scene2;
//    Scene scene3;
//    Scene scene4;

            AnchorPane anchorPane=new AnchorPane();
            window.setTitle("Premier League Sri Lanka");
            Label label = new Label(
                    "Welcome to Premiere League Sri Lanka");
            label.setStyle("-fx-text-fill:black;-fx-font-size: 20px;-fx-font-weight: bold;");
            label.setPadding(new Insets(110,0,500,130));
            BackgroundImage image= new BackgroundImage(new Image("LPL.",880,500,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            anchorPane.setBackground(new Background(image));
            Button button1=new Button("Display teams statistics");
            button1.setLayoutX(50);
            button1.setLayoutY(50);


//        new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {

            button1.setPrefWidth(150);
            button1.setStyle("-fx-background-color:#2ecc71");

            VBox vbox = new VBox(20);
            anchorPane.getChildren().addAll(label,vbox,button1);

            Scene scene = new Scene(anchorPane,880,500);
            window.setScene(scene);
            window.showAndWait();
        }

        private void loadTeams(){
            System.out.println(clubList);


        }

        public void loadMatches(List<Match> matchList){

            Stage window = new Stage();
            window.setTitle("Played matches");


            ObservableList<Match> playedMatch = FXCollections.observableArrayList();
            TableView<Match> table = new TableView<>();
            TableColumn<Match, Date> column1 = new TableColumn<>("Date");
            column1.setMinWidth(50);
            column1.setCellValueFactory(new PropertyValueFactory<>("date"));

            TableColumn<Match,FootballClub> column2 = new TableColumn<>("Team one");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("team_1"));

            TableColumn<Match,FootballClub> column3 = new TableColumn<>("Team two");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("team_2"));

            TableColumn<Match,FootballClub> column4 = new TableColumn<>("Gals scored Team 1");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("goalsTeam_1"));

            TableColumn<Match,FootballClub> column5 = new TableColumn<>("Goals scored team 2");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("goalsTeam_2"));



            table.getSortOrder().add(column1);
            playedMatch.addAll(matchList);
            table.setItems(playedMatch);
            table.getColumns().addAll(column1,column2,column3,column4,column5);

            VBox vbox = new VBox(20);
            vbox.getChildren().addAll(table);
            Scene scene = new Scene(vbox,880,500);
            window.setScene(scene);
            window.showAndWait();}

        //System.out.println(matchList);




        public void searchMatch(){
            Scene scene = new Scene(new Group());
            Stage window = new Stage();
            window.setTitle("Search match");
            ObservableList<Match> playedMatch = FXCollections.observableArrayList();
            TableColumn<Match,FootballClub> column2 = new TableColumn<>("Team one");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("team_1"));

            TableColumn<Match,FootballClub> column3 = new TableColumn<>("Team two");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("team_2"));

            TableColumn<Match,FootballClub> column4 = new TableColumn<>("Gals scored Team 1");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("goalsTeam_1"));

            TableColumn<Match,FootballClub> column5 = new TableColumn<>("Goals scored team 2");
            column2.setMinWidth(50);
            column2.setCellValueFactory(new PropertyValueFactory<>("goalsTeam_2"));

            TableColumn<Match, Date> column1 = new TableColumn<>("Date");
            column1.setMinWidth(50);
            column1.setCellValueFactory(new PropertyValueFactory<>("date"));


//    table.getColumns().addAll(column1,column2,column3,column4,column5);

            FilteredList<Match> filteredMatch = new FilteredList(playedMatch, m -> true);//Pass the data to a filtered list
            table.setItems(filteredMatch);//Set the table's items using the filtered list
            table.getColumns().addAll(column1,column2, column3);

            //Adding ChoiceBox and TextField here!
            ChoiceBox<String> choiceBox = new ChoiceBox();
            choiceBox.getItems().addAll("Played date", "Team (1) Name", "Team(2) Name");
            choiceBox.setValue("date");

            TextField textField = new TextField();
            textField.setPromptText("Search here!");
            textField.setOnKeyReleased(keyEvent ->
            {
                switch (choiceBox.getValue())//Switch on choiceBox value
                {
                    case "Played date":
                        filteredMatch.setPredicate(m -> m.getDate().equals(textField.getText().toLowerCase().trim()));
                        break;
                    case "Team (1) Name":
                        filteredMatch.setPredicate(m -> m.getTeam_1().equals(textField.getText().toLowerCase().trim()));
                        break;
                    case "Team(2) Name":
                        filteredMatch.setPredicate(m -> m.getTeam_2().equals(textField.getText().toLowerCase().trim()));
                        break;
                }
            });
            choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) ->
            {//reset table and textfield when new choice is selected
                if (newVal != null)
                {
                    textField.setText("");
                    filteredMatch.setPredicate(null);
                }
            });
            HBox hBox = new HBox(choiceBox, textField);//Add choiceBox and textField to hBox
            hBox.setAlignment(Pos.CENTER);//Center HBox
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(table, hBox);

            ((Group) scene.getRoot()).getChildren().addAll(vbox);

            window.setScene(scene);
            window.show();
        }

    }



















