import React from "react";

import {
  Paper,
  Grid
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles(theme => ({
  flex: {
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    minHeight: "88vh"
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 300
  },
  margin: {
    margin: theme.spacing(1)
  }
}));

const FlexPaperTemplate = props => {
  const classes = useStyles();

  return (
    <Grid container className={classes.flex}>
      <Grid item xs={12}>
        <Paper className={classes.paper}>{props.children}</Paper>
      </Grid>
    </Grid>
  );
};

export default FlexPaperTemplate;
