import React, { useContext } from "react";
import { makeStyles, Typography, AppBar, Toolbar } from "@material-ui/core";

import { CommonContext } from "../context/CommonContext";

const useStyles = makeStyles(theme => ({
  appBarFooter: {
    top: "auto",
    bottom: 0
  },
  toolbar: {
    minHeight: 30
  }
}));

const Footer = props => {
  const {} = useContext(CommonContext);

  const classes = useStyles();
  return (
    <AppBar position="fixed" className={classes.appBarFooter}>
      <Toolbar className={classes.toolbar}>
        <Typography variant="body2" noWrap>
          Copyright © 25+2d corp. all rights reserved
        </Typography>
      </Toolbar>
    </AppBar>
  );
};

export default Footer;
