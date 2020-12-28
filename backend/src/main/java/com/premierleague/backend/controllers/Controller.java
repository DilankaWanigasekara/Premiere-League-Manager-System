package com.premierleague.backend.controllers;
import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;
import com.premierleague.backend.operations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@org.springframework.web.bind.annotation.RestController
public class Controller {

    Operation operation = new Operation();

    @GetMapping(value = "/getTeams")
    public List<FootballClub> getTeams(){
        return operation.getTeams();
    }

    @PostMapping(value = "/generateMatch")
    public Match generateMatch() throws IOException { // ops, need to mention JSON eke body eken ganne kiyala
        return operation.generateMatch();
    }

    @GetMapping(value = "/getMatches")
    public List<Match> getMatches(){
        return operation.getMatches();
    }

    @GetMapping(value = "/getPlayedMatches")
    public List<Match> getPlayedMatches(@RequestBody Date date){
        return operation.getPlayedMatches(date);
    }








}
