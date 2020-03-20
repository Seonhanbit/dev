import React, { useEffect, useState, Fragment } from 'react';

import {
  makeStyles,
  LinearProgress,
  Grid,
  Paper,
  Button
} from "@material-ui/core";

const infoStyle = {
  textAlign: "center",
  color:'#bdbdbd',
  margin : -1 -1 -5
}

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
  },
  paperHeader: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
  submitButton: {
    justifyContent: "center",
  },
}));

const UserVoteStandBy = props => {
  const classes = useStyles();

  const [votenamelist, setVoteNameList] = useState(null);
  const [loading, setLoading] = useState(null);

  useEffect(() => {
    setLoading(true)
    const temp_votenamelist = []
    if (props.votelist !== null) {
      for (let eachvote of props.votelist.keys()) {
        // console.log(eachvote)
        temp_votenamelist.push(eachvote)
      }
    }
    setVoteNameList(temp_votenamelist)
    
    setLoading(false)
  }, [props.votelist])

  const changeStatus = () => {
    props.setStatus(status => 'vote')
  }

  if (loading === false) {        
    return (
      <Fragment>
        <div className={classes.flex}>
          <Grid
            container
            spacing={3}
            className={classes.header}
          >
            <Grid item xs={12}>
              <Paper elevation={0} className={classes.paperHeader}>
                <h1> {props.username}님, 진행할 투표가 총 <font color="red">{votenamelist.length}</font>개가 있습니다.</h1>
                 <h3>아래 투표 시작 버튼을 클릭해주세요.</h3>
              </Paper>
            </Grid>
          </Grid>
          <Grid container spacing={3} className={classes.body}>
            {votenamelist.map((vote)=>{
              return (
                <Grid item xs={12} key={vote.code}>
                  <Paper elevation={0}>
                    {vote.name}
                    <hr></hr>
                  </Paper>
                </Grid>
              )
            })}
            </Grid>
            <p style={infoStyle} className="infodiv">해당 투표를 모두 완료하셔야 투표가 완료됩니다.</p>
          <Grid container spacing={3} className={classes.header}>
            <Grid item xs={12}>
              <Paper elevation={0} className={classes.paperHeader}>              
                <Button
                  onClick={changeStatus}
                  variant="contained"
                  color="primary"
                  disableElevation
                  className={classes.submitButton}
                  fullWidth={true}
                >
                  투표 시작
                </Button>
              </Paper>
            </Grid>
          </Grid>
        </div>
      </Fragment>
    )
  } else {
      return (
        <Fragment>
            <LinearProgress />
        </Fragment>
    )
  }
}

export default UserVoteStandBy;