import React, {useState, useEffect} from 'react';
import  Axios  from "axios";
import './App.css';
import {DataGrid} from "@material-ui/data-grid"
import DatePicker from "react-datepicker";
 
import "react-datepicker/dist/react-datepicker.css";

function Match(){

    const columns = [
        { field: 'id', headerName: 'ID', width: 200 },
        { field: 'date', headerName: 'Date', width: 200 },
        { field: 'club1', headerName: 'Club Name', width: 200 },
        { field: 'goalsTeam_1', headerName: 'Club Goals', width: 200 },
        { field: 'club2', headerName: 'Club Name', width: 200 },
        { field: 'goalsTeam_2', headerName: 'Club Goals', width: 200 },
        
      ];   

      const [matches, setMatches] = useState([]);
      const [date, setDate] = useState();

      const getMatches = () => {
        let matchList = []
          Axios.get("http://localhost:8080/getMatches").then(
          (response) => {
              console.log(response.data);
              setMatches(response?.data);
              for(var r of response?.data){
                r.club1 = r?.team_1?.name
                r.club2 = r?.team_2?.name
                r.date = r?.date?.day + "-" + r?.date?.month + "-" + r?.date?.year;
                matchList.push(r);
              }
          }
          );
          setMatches(matchList);

      }

      const getMatchesByDate = (date) => {
        let matchList = []
          Axios.get(`http://localhost:8080/getMatches/${date}`).then(
          (response) => {
              console.log(response.data);
              setMatches(response?.data);
              for(var r of response?.data){
                r.club1 = r?.team_1?.name
                r.club2 = r?.team_2?.name
                r.date = r?.date?.day + "/" + r?.date?.month + "/" + r?.date?.year;
                matchList.push(r);
              }
          }
          );
          setMatches(matchList);
      }

      const convertDate = (str) => { // 11 Nov 2020
        str = str.toString();
        let parts = str.split(" ");
        let months = {
          Jan: "01",
          Feb: "02",
          Mar: "03",
          Apr: "04",
          May: "05",
          Jun: "06",
          Jul: "07",
          Aug: "08",
          Sep: "09",
          Oct: "10",
          Nov: "11",
          Dec: "12"
        };
        return parts[2] + "-" + months[parts[1]] + "-" + parts[3]; // 11-11-2020
      };
  
      useEffect(()=> {
        if (date == null){
          getMatches();
        }else{
          const selDate = convertDate(date)
          getMatchesByDate(selDate);
        }
        
      },[date])

    return(
      <div className= "matches">
        <h1 className="headings">Match List</h1>
        <div className="datepicker">
           <DatePicker selected={date} onChange={date => setDate(date)} />
           <button onClick={()=>setDate(null)}> Clear Date </button>
        </div>
        
          
      
        <div className="tabledata">
            <DataGrid className="MuiDataGrid-row" rows={matches} pageSize={5} columns={columns} autoHeight />
        </div>
      </div>
    );
}

export default Match;