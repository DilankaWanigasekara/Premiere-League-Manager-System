import React, {useState} from 'react';
import  Axios  from "axios";
import './App.css';

function Match(team, goals){
    return(
        <div> 
            {team.winner? 
                <div>
                    {team.winner === "draw"?                     
                        <div className="matchCard-draw">
                            <h3>{team?.name}</h3>
                            <p><b>Goals Scored:</b> {goals}</p>
                            <p><b>Current Points:</b> {team?.currentPoints}</p>
                        </div>                    
                        :                       
                        <div className="matchCard-win">
                            <h3>{team?.name}</h3>
                            <p><b>Goals Scored:</b> {goals}</p>
                            <p><b>Current Points:</b> {team?.currentPoints}</p>
                        </div>
                    }                   
                </div>
            :
            <div className="matchCard-loose">
                <h3>{team?.name}</h3>
                <p><b>Goals Scored:</b> {goals}</p>
                <p><b>Current Points:</b> {team?.currentPoints}</p>
            </div>         
            }
        </div>
    );
}

export default function GenerateMatch() {

    const [match, setMatch] = useState();
    const [team1, setTeam1] = useState();
    const [team2, setTeam2] = useState();
    const [date, setDate] = useState();

    const generateMatch = () => {
          Axios.post("http://localhost:8080/generateMatch").then(
          (response) => {
              console.log(response.data);   
              setMatch(response?.data);  
              if(response?.data.goalsTeam_1 > response?.data.goalsTeam_2){
                response.data.team_1.winner = true;
                response.data.team_2.winner = false;
              }else if(response?.data.goalsTeam_2 > response?.data.goalsTeam_1){
                response.data.team_2.winner = true;
                response.data.team_1.winner = false;
              }else{
                response.data.team_1.winner = 'draw';
                response.data.team_2.winner = 'draw';
              }
              setTeam1(response?.data?.team_1);
              setTeam2(response?.data?.team_2);
              setDate(response?.data?.date);
          }
          );
    }


    return (
        <div className="generatematch">
            <h1 className="headings">Match List</h1>
            <div className="headings">
                <div className="genButton">
                    <button onClick={()=>generateMatch()}>Generate match</button> 
                </div>

                <hr />
                
                {date?
                <div>
                    <div>
                    <h3>Match Details...</h3>
                    <h4>Date: {date?.day + "-" + date?.month + "-" + date?.year}</h4>
                    <div className="matchdetails">
                        {Match(team1, match?.goalsTeam_1)}
                        <b className="verses">VS</b>
                        {Match(team2, match?.goalsTeam_2)}
                    </div>
                </div>
                </div>
                :""}
            </div>
        </div>
    )
}

