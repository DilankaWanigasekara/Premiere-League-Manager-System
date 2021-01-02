import Nav from './Nav';
import Match from'./Match';
import Team from './Team';
import Home from './Home';
import generateMatch from './GenerateMatch';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';

function App(){
    
        
    return(
      <Router> 
         <div className="App">
           <header id ='main'>
        <Nav/>
          <Switch>
            <Route path="/Home" component= {Home}/>
            <Route path="/Match" component= {Match}/>
            <Route path="/Team" component= {Team}/>
            <Route path="/GenerateMatch" component= {generateMatch}/>
          </Switch>
          </header> 
          </div> 
        </Router>  
        
        
        
        
    );
    
   
};
    


export default App;
// //Access-Control-Allow-Origin ('http://localhost:8080/');

// //import axios from 'axios';
// const App=()=>{
// useEffect(()=>{
// getTeams();
// console.log("hi");
// });

// const getTeams=async()=>{
//     const response = await fetch ('http://localhost:8080/getMatches/11-11-2222');
//     const data= await response.json();
//     console.log(data);

//     // const response = {
//     //          method: 'GET',
//     //          headers: {application/json',
//     //              'Content-type':'application/json',
//     //          },
//     //          body: date,
//     //         };
//     //         fetch('http://localhost:8080/getMatches',response)} // oya get teams 
        
// //const [teams,setTeams]= useState([]);
// // const getTeams=async()=>{
// // const response = {
// //     method: 'POST',
// //     headers: {
// //         Accept:'application/json',
// //         'Content-type':'application/json',
// //     }};



// // try{
// //     const fetchdata=await fetch('http://localhost:8080/generateMatch',response);
// //     const data=await fetchdata.json();
// //     console.log(data);
// // }catch (e){
// //     return e;
// // }
// // }

// return (
//     <h1>hi</h1>
//     // <div className="page">
//     //     <form className="form">
//     //         <input className="search-bar" type="text"/>
//     //         <button className="button" type="submit">Search</button>
//     //     </form>

//     // </div>
// );

// //     await fetch ('http://localhost:8080/generateMatch');
// // const data= await response.json();
// // console.log(data);


//     };
// };
// export default App;
// const App=()=>{

//     useEffect(()=>{
//         getteam();
//     });

// // const date={
// //     "day":11,
// //     "month":10,
// //     "year":2020
// // }
// const getteam = async() => {
//     const response = await fetch('http://localhost:8080/getMatches/11-09-2222');
//     const data = await response.json();
//     console.log(data)
// }// oya kerepu widihata try


