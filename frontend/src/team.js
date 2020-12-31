import React,{useEffect}from 'react';
const Team=()=>{
useEffect(()=>{
getTeams();
console.log("hi");
});

const getTeams=async()=>{
    const response = await fetch ('http://localhost:8080/getTeams/11-11-2222');
    const data= await response.json();
    console.log(data);
};
return(
    <div>
        Teams
    </div>
);
};

export default Team;