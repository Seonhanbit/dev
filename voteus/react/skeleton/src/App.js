import React from "react";
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import { createMuiTheme, MuiThemeProvider } from "@material-ui/core/styles";
import { CommonContext } from "./context/CommonContext";

import NotFound from "./pages/NotFound";
import VoteMain from "./pages/VoteMain";
import SignInSide from "./pages/SignInSide";
import VoteList from "./pages/VoteList";
import MainPartList from "./pages/MainPartList";
import MiddlePartList from "./pages/MiddlePartList";
import AreaList from "./pages/AreaList";
import PartyList from "./pages/PartyList";
import CandidateList from "./pages/CandidateList";
import VoterList from "./pages/VoterList";
import PrivateRoute from "./components/login/PrivateRoute";

import { koKR } from "@material-ui/core/locale";

import "./index.css";

const theme = createMuiTheme(
  {
    palette: {
      type: "light"
    },
    drawerWidth: 320,
    typography: {
      fontFamily: ["CookieRun-Regular"].join(","),
      button: {
        fontFamily: "CookieRun-Regular"
      },
      thead: {
        fontFamily: "CookieRunOTF-Bold"
      },
      body1: {
        fontWeight: 500
      }
    },
    overrides: {
      MuiCssBaseline: {
        "@global": {
          body: {
            backgroundColor: "#f7f7f7"
          }
        }
      }
    }
  },
  koKR
);

const App = () => {
  return (
    <CommonContext.Provider value={{}}>
      <MuiThemeProvider theme={theme}>
        <BrowserRouter>
          <Switch>
            <Route exact path="/" component={SignInSide} />
            <Route path="/SignInSide" component={SignInSide} />
            <PrivateRoute path="/VoteMain" component={VoteMain} />
            <PrivateRoute path="/VoteList" component={VoteList} />
            <PrivateRoute path="/PartyList" component={PartyList} />
            <PrivateRoute path="/AreaList" component={AreaList} />
            <PrivateRoute path="/VoterList" component={VoterList} />
            <PrivateRoute path="/MainPartList" component={MainPartList} />
            <PrivateRoute
              path="/CandidateList/:code/:name"
              component={CandidateList}
            />
            <PrivateRoute
              path="/MiddlePartList/:code/:name"
              component={MiddlePartList}
            />
            <Route path="/not-found" component={NotFound} />
            {/* <Route path="/CandidateList" component={CandidateList} /> */}
            <Redirect to="/not-found" />
          </Switch>
        </BrowserRouter>
      </MuiThemeProvider>
    </CommonContext.Provider>
  );
};

export default App;
