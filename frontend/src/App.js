import './App.css';
import React from 'react';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import Nav from './components/Nav';
import Home from './Pages/Home';
import Matches from './Pages/Matches';
import Teams from './Pages/Teams';
import GenerateMatch from './Pages/GenerateMatch';

function App() {
  return (
    <>
    <Router>
      <Nav />
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/teams" component={Teams} />
          <Route path="/matches" component={Matches} />
          <Route path="/generate-match" component={GenerateMatch} />
        </Switch>
      </Router>
    </>
  );
}

export default App;
