import React, {useState, useEffect} from 'react';
import  Axios  from "axios";
import '../App.css';
import {DataGrid} from "@material-ui/data-grid"

const columns = [
    {
        field: 'id', headerName: 'Club ID', width:130, sortable:false
    },
    {
        field: 'name', headerName: 'Club Name', width:130, sortable:false
    },
    {
        field: 'currentPoints', headerName: 'Points', width: 170, type:'number'
    },
    {
        field: 'wins', headerName: 'Wins', width: 170, type:'number'
    },
    {
        field: 'defeats', headerName: 'Loses', width: 170, type:'number',sortable:false
    },
    {
        field: 'draws', headerName: 'Draws', width: 170, type:'number',sortable:false
    },
    
    {
        field: 'numberOfGoalsScored', headerName: 'Goals Scored', width: 170, type:'number'
    },
    {
        field: 'numberOfGoalsReceived', headerName: 'Goals Recieved', width: 170, type:'number',sortable:false
    },
]

function Teams(){

    const [teams, setTeams] = useState([]);

    const getTeams = () => {
        Axios.get("http://localhost:8080/getTeams").then(
        (response) => {
            console.log(response.data);
            setTeams(response?.data)
        }
        );
    }

    useEffect(()=> {
        getTeams()
    },[])

    return(
        <div className="teams">
            <h1 className="headings">Club List</h1>
            <div className="tabledata">
                <DataGrid rows={teams} columns={columns} pageSize={5} autoHeight/>
            </div>
        </div>
    );
}

export default Teams;