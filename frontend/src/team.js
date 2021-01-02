import React, {useState, useEffect} from 'react';
import  Axios  from "axios";
import './App.css';
import {DataGrid} from "@material-ui/data-grid"

const columns = [
    {
        field: 'id', headerName: 'Club ID', width:130, sortable:false
    },
    {
        field: 'name', headerName: 'Club Name', width:130, sortable:false
    },
    {
        field: 'wins', headerName: 'Wins', width: 130, type:'number'
    },
    {
        field: 'defeats', headerName: 'Loses', width: 130, type:'number'
    },
    {
        field: 'draws', headerName: 'Draws', width: 130, type:'number'
    },
    {
        field: 'currentPoints', headerName: 'Points', width: 130, type:'number'
    }
]

function Team(){

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

export default Team;