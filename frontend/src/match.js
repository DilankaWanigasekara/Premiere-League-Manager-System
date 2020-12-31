import React,{useEffect}from 'react';
const Match=()=>{
useEffect(()=>{
getMatches();
console.log("hi");
});

const getMatches=async()=>{
    const response = await fetch ('http://localhost:8080/getMatches/11-11-2222');
    const data= await response.json();
    console.log(data);
};
return(
    <div>
        Matches with dates
    </div>
);
// const App=()=>{

//     useEffect(()=>{
//         getteam();
//     });

// const date={
//     "day":11,
//     "month":10,
//     "year":2020
// }
// const getteam = async() => {
//     const response = await fetch('http://localhost:8080/getMatches/11-09-2222');
//     const data = await response.json();
//     console.log(data)
// }// oya kerepu widihata try


   
// }

};


export default Match;