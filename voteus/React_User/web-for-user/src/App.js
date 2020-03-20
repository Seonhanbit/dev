import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";

import "./App.css";

import UserHome from "./pages/UserHome";
import UserAuthentication from "./pages/UserAuthentication";
import UserVote from "./pages/UserVote";
import PageNotFound from "./pages/PageNotFound";


// import TypeContext from "./context/TypeContext";

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route exact path="/" component={UserHome} />
          <Route path="/user-home" component={UserHome} />
          {/* <TypeContext.Provider value={'auth'}> */}
          <Route path="/user-auth" component={UserAuthentication} />
          {/* </TypeContext.Provider> */}
          <Route path="/user-vote/:code/:name" component={UserVote} />
          <Route path="/page-not-found" component={PageNotFound} />
          <Redirect to="/page-not-found" />
        </Switch>
      </Router>
    );
  }
}

export default App;
