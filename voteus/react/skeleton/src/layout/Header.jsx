import React, { useContext } from "react";
import {
  makeStyles,
  Typography,
  AppBar,
  Toolbar,
  IconButton
} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import ExitToAppIcon from "@material-ui/icons/ExitToApp";
import { CommonContext } from "../context/CommonContext";
import Icon from "@material-ui/core/Icon";
import Drawer from "./Drawer";
import { Link } from "react-router-dom";

const useStyles = makeStyles(theme => ({
  appBar: {
    // padding: `0 calc(10px + 2vw)`
  },
  menuButton: {
    marginRight: theme.spacing(2)
  },
  title: {
    flexGrow: 1,
    cursor: "pointer"
  }
}));

const Header = props => {
  const classes = useStyles();

  const logOutEvent = () => {
    sessionStorage.clear();
  };

  return (
    <AppBar position="fixed" className={classes.appBar}>
      <Toolbar>
        <Drawer />
        <Typography variant="h6" className={classes.title}>
          <Link
            to="/VoteMain"
            style={{ color: "white", textDecorationLine: "none" }}
          >
            VOTE US ADMIN
          </Link>
        </Typography>
        <IconButton
          aria-label="account of current user"
          aria-controls="menu-appbar"
          aria-haspopup="true"
          color="inherit"
          size="medium"
          onClick={logOutEvent}
        >
          <Link
            to="/SignInSide"
            style={{ color: "white", textDecorationLine: "none" }}
          >
            <ExitToAppIcon />
          </Link>
        </IconButton>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
