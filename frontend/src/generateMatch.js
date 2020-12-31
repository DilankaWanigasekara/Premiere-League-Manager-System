import React from 'react';
const generateMatch=async()=>{
    const response = {
        method: 'POST',
        headers: {
            Accept:'application/json',
            'Content-type':'application/json',
        }};
    
    
    try{
        const fetchdata=await fetch('http://localhost:8080/generateMatch',response);
        const data=await fetchdata.json();
        console.log(data);
    }catch (e){
        return e;
    };
    return(
        <div>
            generate matches.....
        </div>
    );
    }
    export default generateMatch;