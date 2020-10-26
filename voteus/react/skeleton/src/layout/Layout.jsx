import React, { Fragment, useContext } from "react";
import Header from "./Header";
import Footer from "./Footer";
import Drawer from "./Drawer";

import { CssBaseline, Container, makeStyles } from "@material-ui/core";
import { CommonContext } from "../context/CommonContext";

const useStyles = makeStyles(theme => ({
  content: {
    margin: "0 auto"
  },
  container: {
    marginTop: "100px",
    marginBottom: "30px"
  }
}));

const Layout = props => {
  const classes = useStyles();
  const {} = useContext(CommonContext);

  return (
    <Fragment>
      <CssBaseline />
      <Header />
      <Container className={classes.content} maxWidth="xl">
        <div className={classes.container}>{props.children}</div>
      </Container>
      <Footer />
    </Fragment>
  );
};

export default Layout;
