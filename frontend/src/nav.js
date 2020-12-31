import React from 'react';
import './App.css';
// import {Link} from 'react-router-dom';
import {Navdata} from './navdata';


 function Nav(){
     return( <div className="nav">
         <ul className="navlist">
            {
                 Navdata.map(val,key)=> {
                     return (
                         <li
                         key={key}
                         className="row"
                         id={ window.location.pathname===val.links? "active" :""}
                         onclick={
                             ()=> {
                                 window.location.pathname=val.links;
                             }
                         }>
                            {""}
                            <div id="icon">{val.icon}</div>
                            <div id="title">{val.title}</div>
                            </li>);
                            }        )
                
                
            }
                        
        </ul>
         
     </div>
     );
                    
     
        //     <nav>
        //         <ul class name="navigetion-links">
                    
        //             <Link to="/team" style={navigetionStyle}> 
        //             <li>Teams</li></Link>
        //             <Link to="generateMatch" style={navigetionStyle}>
        //             <li>Generate Matches</li></Link>
        //             <Link to="/match" style={navigetionStyle}><li>Matches</li></Link>
        //         </ul>
        //     </nav>
        // );
        
 }
 
//     const navigetionStyle={
//         color:'white'
//     };
// return(
//     <nav>
//         <ul class name="navigetion-links">
            
//             <Link to="/team" style={navigetionStyle}> 
//             <li>Teams</li></Link>
//             <Link to="generateMatch" style={navigetionStyle}>
//             <li>Generate Matches</li></Link>
//             <Link to="/match" style={navigetionStyle}><li>Matches</li></Link>
//         </ul>
//     </nav>
// );


// };

export default Nav;