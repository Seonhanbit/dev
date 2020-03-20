import React, { useState, useEffect, Fragment } from 'react';

import { Redirect } from 'react-router-dom';

//image
import lock from "../images/lock.png";

import {
  makeStyles,
  Grid,
  Paper,
  Button
} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
  flex: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  header: {
    padding: theme.spacing(1),
    // margin: theme.spacing(1),
  },
  body : {
    paddingLeft: theme.spacing(3),
    paddingRight: theme.spacing(3),
    marginBottom: theme.spacing(3)
  },
  paperHeader: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
}));

const UserVoteEnd = props => {
  const classes = useStyles();

  const [waitnumber, setWaitNumber] = useState(5);
  const [redirect, setRedirect] = useState(false);

  const url = "/";

  useEffect(() => {
    setTimeout(()=>{setWaitNumber(4)}, 1000)
    setTimeout(()=>{setWaitNumber(3)}, 2000)
    setTimeout(()=>{setWaitNumber(2)}, 3000)
    setTimeout(()=>{setWaitNumber(1)}, 4000)
    setTimeout(()=>{setRedirect(true)}, 5000)
  },[])

  return (
    <Fragment>
      <div className={classes.flex}>
        <Grid container spacing={3} className={classes.header}>
          <Grid item xs={12}>
            <Paper elevation={0} className={classes.paperHeader}>
              <h2>감사합니다.</h2>
              <h2>모든 투표가 완료되었습니다.</h2>
              <img src={lock} height="30" alt="투표 완료 이미지"/>
              {redirect === true ? <Redirect to="/" /> : <h4> 이 페이지는 {waitnumber}초 후 자동으로 투표가 종료됩니다.</h4>}
            </Paper>
          </Grid>
        </Grid>
        <Grid container spacing={3} className={classes.body}>
          <Grid item xs={12}>
            <Button variant="contained" color="primary" href={url}>투표 종료</Button>
          </Grid>
        </Grid>
      </div>
    </Fragment>
  )
}

export default UserVoteEnd;