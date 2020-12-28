package com.premierleague.backend.console_app;

import com.premierleague.backend.models.Date;

public interface LeagueManager {
    void createClub() ;
    void deleteClub(int id);
    void displayClubStatistics(int id);
    void displayPremierLeagueTable();
    void addPlayedMatch(int team1, int team2, int goalsTeams1, int goalsTeam2, Date playedDate);
    void openGUI();
    void saveAndExit();
}
