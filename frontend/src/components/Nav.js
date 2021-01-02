  
import React from 'react';
import '../App.css';
import {Link} from 'react-router-dom';

function Nav() {
  const navStyle = {
      color:'white'
  };

  return (
    <nav>
        <Link style={navStyle} to='/'>
                <h3>Premiere League Manager</h3>
        </Link>
        <ul className="nav-links">
            <Link style={navStyle} to='/teams'>
                <li>| Teams</li>
            </Link>
            <Link style={navStyle} to='/matches'>
                <li>| Matches</li>
            </Link>
            <Link style={navStyle} to='/generate-match'>
                <li>| Generate Match</li>
            </Link>
        </ul>
    </nav>
  );
}

export default Nav;