import React from "react";
import { Grid, Typography, makeStyles } from "@material-ui/core";

const useStyles = makeStyles({
  VoteGridTitleGrid: {
    margin: 30
  },
  VoteGridTitleTypography1: {
    fontWeight: 900,
    fontSize: 70
  },
  VoteGridTitleTypography2: {
    maxWidth: 1000,
    margin: "15px auto 60px",
    wordBreak: "keep-all",
    fontSize: 24,
    lineHeight: 1.25,
    fontWeight: 500
  }
});

const VoteGridTitle = props => {
  const classes = useStyles();
  const { item } = props;
  return (
    <Grid className={classes.VoteGridTitleGrid}>
      <Typography
        variant="h2"
        align="center"
        className={classes.VoteGridTitleTypography1}
      >
        {item.title}
      </Typography>
      <Typography
        variant="h6"
        align="center"
        className={classes.VoteGridTitleTypography2}
      >
        {item.subtitle}
      </Typography>
    </Grid>
  );
};

export default VoteGridTitle;
