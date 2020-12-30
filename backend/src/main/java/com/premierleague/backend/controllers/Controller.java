package com.premierleague.backend.controllers;
import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;
import com.premierleague.backend.operations.Operation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@SpringBootApplication
@RestController
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

    @GetMapping(value = "/getMatches/{d}")
    public List<Match> getPlayedMatches(@PathVariable String d){
        String[] parts = d.split("-");
        System.out.println(Arrays.toString(parts));
        Date date = new Date(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        return operation.getPlayedMatches(date);
    }








}
