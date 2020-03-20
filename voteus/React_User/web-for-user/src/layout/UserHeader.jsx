import React, { useContext, Fragment } from "react";

import TypeContext from "../context/TypeContext";

import {
  AppBar,
  Toolbar,
  Typography,
  IconButton
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import HomeRoundedIcon from "@material-ui/icons/HomeRounded";

const useStyles = makeStyles(theme => ({
  root: {
    display: "flex",
    flexWrap: "wrap"
  },
  title: {
    flexGrow: 1,
    textAlign: "center"
  }
}));

const UserHeader = props => {
  const classes = useStyles();

  const type = useContext(TypeContext);
  
  const clear = () => {
    sessionStorage.clear();
  }

  return (
    <Fragment>
      <div className={classes.root}>
        <AppBar position="static">
          <Toolbar>
            {type === 'auth' ? (
              <IconButton
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                color="inherit"
                href="/"
                style={{visibility: 'hidden'}}
              >
                <HomeRoundedIcon />
              </IconButton>
            ) : (
              null
            )}
            <Typography variant="h6" className={classes.title}>
              전자투표시스템
            </Typography>
            <div>
              {type === 'auth' ? (
                <IconButton
                  aria-label="account of current user"
                  aria-controls="menu-appbar"
                  aria-haspopup="true"
                  color="inherit"
                  onClick={clear}
                  href="/"
                >
                  <HomeRoundedIcon />
                </IconButton>
              ) : (
                null
              )}
            </div>
          </Toolbar>
        </AppBar>
      </div>
    </Fragment>
  );
};

export default UserHeader;
