import React, { useContext, useState, useEffect, Fragment } from 'react';

import PartyLicsContext from '../../context/PartyListContext';

import {
  makeStyles,
  LinearProgress,
  Grid,
  Paper,
  Card,
  CardContent,
  Typography
} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
  flex: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "flex-start",
  },
  header: {
    padding: theme.spacing(1),
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
  cardBody: {
    boxShadow: "0 3px 3px rgba(0,0,0,0.23)",
    "&:hover": {
      boxShadow: "0 4px 20px -6px #1a237e"
    },
    backgroundColor: '#e3f2fd',
    borderRadius: theme.spacing(3),
    borderColor: "#757575",
  },
  party: {
    textAlign: "left",
    paddingLeft: theme.spacing(2),
    paddingRight: theme.spacing(2),
    // color: "#9e9e9e",
    color: "#3f51b5",
  },
  candidate: {
    paddingTop: theme.spacing(1),
    paddingBottom: theme.spacing(1),
    textAlign: "center",
  },
  cardCandidate: {
    padding: theme.spacing(1),
    "&:last-child": {
      paddingBottom: theme.spacing(2)
    }
  }
}));

const UserVoteCandidateList = props => {
  const classes = useStyles();

  const partylist = useContext(PartyLicsContext);

  const [loading, setLoading] = useState(null);

  useEffect(() => {
    setLoading(true)
    setLoading(false)
  }, [props.candidatelist])

  if (loading === false) {
    return (
      <Fragment>
        <div className={classes.flex}>
         <Grid container spacing={3} className={classes.header}>
          <Grid item xs={12}>
            <Paper elevation={0} className={classes.paperHeader}>
              <h1 style={{color: "black"}}>{props.votename}</h1>
              <h2>후보를 선택해주세요.</h2>
              {props.selectname === "무효표" ? (
                <h4 style={{color: "#9e9e9e"}}>현재 <span style={{color: "#424242"}}>{props.selectname}</span>를 선택하셨습니다.</h4>
              ):(
                (props.selectname === null) ? (
                  null
                ):(
                  <h4 style={{color: "#9e9e9e", margin:"0"}}>현재 <span style={{color: "#424242"}}>{props.selectname} 후보</span>에게 투표하셨습니다.</h4>
                )
              )}
            </Paper>
          </Grid>
        </Grid>
        <Grid container spacing={3} className={classes.body}>
          {props.candidatelist[0].map((eachcandidate) => {
            const selectCandidate = () => {
              props.result.set(props.votenumber, eachcandidate.code)
              props.setResult(props.result)
              props.setVoteNumber(null)
            }

            if (partylist[eachcandidate.party] === "정당없음") {
              return (
                <Grid item xs={6} key={eachcandidate.code}>
                  <Card
                    variant="outlined"
                    onClick={selectCandidate}
                    className={classes.cardBody}
                  >
                    <CardContent className={classes.cardCandidate}>
                      <Typography className={classes.party}>
                        기호 없음
                      </Typography>
                      <Typography className={classes.candidate}>
                        {eachcandidate.name}
                      </Typography>
                    </CardContent>
                  </Card>
                </Grid>
              )
            } else {
              return (
                <Grid item xs={6} key={eachcandidate.code}>
                  <Card
                    variant="outlined"
                    onClick={selectCandidate}
                    className={classes.cardBody}
                  >
                    <CardContent className={classes.cardCandidate}>
                      <Typography className={classes.party}>
                        기호 {eachcandidate.num}번 {partylist[eachcandidate.party]}
                      </Typography>
                      <Typography className={classes.candidate}>
                        {eachcandidate.name}
                      </Typography>
                    </CardContent>
                  </Card>
                </Grid>
              )
            }
          })}
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

export default UserVoteCandidateList;