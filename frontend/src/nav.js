import React from 'react';
import './App.css';

import {Link} from 'react-router-dom';

function Nav(){
const navigationStyle={
    color:'white'
}

return(
        <nav>
            <ul className="navigation-links">
                
                <Link to="/team" style={navigationStyle}> 
                <li>Teams</li></Link>
                <Link to="generateMatch" style={navigationStyle}>
                <li>Generate Matches</li></Link>
                <Link to="/match" style={navigationStyle}><li>Matches</li></Link>
            </ul>
        </nav>
    );
                    
    
};
export default Nav;