import React from 'react';
import './App.css';
import {Link} from 'react-router-dom';

function Nav() {
  const Style = {
      color:'white'
  };

  return (
    <nav>
        <Link style={Style} to='/'>
                <h3>Premiere League Manager</h3>
        </Link>
        <ul className="nav-links">
        <Link style={Style} to='/home'>
                <li>|Home </li>
            </Link>
            <Link style={Style} to='/teams'>
                <li>| Teams</li>
            </Link>
            <Link style={Style} to='/matches'>
                <li>| Matches</li>
            </Link>
            <Link style={Style} to='/generate-match'>
                <li>| Generate Match</li>
            </Link>
            
        </ul>
    </nav>
  );
}

export default Nav;