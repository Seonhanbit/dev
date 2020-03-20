import React, { useState, useEffect, useContext, Fragment } from 'react';

import VoteListContext from '../../context/VoteListContext';

import voteStamp from "../../images/voteStamp.png";

import {
  makeStyles,
  LinearProgress,
  Grid,
  Paper,
  Card,
  CardContent,
  Typography,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Checkbox
} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
  flex: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  header: {
    padding: theme.spacing(1),
  },
  body : {
    paddingLeft: theme.spacing(3),
    paddingRight: theme.spacing(3),
    marginBottom: theme.spacing(1),
  },
  paperHeader: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary,
  },
  cardBody: {
    marginBottom: theme.spacing(0.5),
    boxShadow: "0 3px 3px rgba(0,0,0,0.23)",
    "&:hover": {
      boxShadow: "0 4px 20px -6px #880e4f",
    },
    borderRadius: theme.spacing(2),
    borderColor: "#f44336"
  },
  cardBodySelect: {
    marginBottom: theme.spacing(0.5),
    boxShadow: "0 3px 3px rgba(0,0,0,0.23)",
    "&:hover": {
      boxShadow: "0 4px 20px -6px #1b5e20",
    },
    backgroundColor: "#ffecb3",
    borderRadius: theme.spacing(2),
    borderColor: "#ffa000",
  },
  vote: {
    padding: theme.spacing(1),
  },
  candidate: {
    textAlign: "center",
  },
  candidateNone: {
    textAlign: "center",
    color: "#f6685e",
  },
  submitButton: {
    justifyContent: "center",
    marginTop: theme.spacing(2),
    marginBottom: theme.spacing(2),
  },
  candidateColor: {
    backgroundColor: "#e1bee7",
  },
  dialog: {
    paddingTop: theme.spacing(5),
    paddingBottom: theme.spacing(5),
  },
  textCenter: {
    textAlign: "center",
  },
  buttonSpace: {
    paddingLeft: theme.spacing(3),
    paddingRight: theme.spacing(3),
  },
  cardSpace: {
    padding: theme.spacing(1),
    "&:last-child": {
      paddingBottom: theme.spacing(2)
    }
  },
  selectedVote: {
    color: "#f57f17",
  },
  checkbox: {
    alignItems: "center",
  },
  votestamp: {
    display: "flex",
    justifyContent: "center",
    alignContent: "center",
  }
}));

const UserVoteList = (props) => {
  window.scrollTo(0, props.scrollheight)

  const classes = useStyles();

  const votelist = useContext(VoteListContext);

  const [dialogopen, setDialogOpen] = useState(false);
  const [vote, setVote] = useState(null);
  const [loading, setLoading] = useState(null);
  
  useEffect(()=>{
    setLoading(true)
    
    if (votelist !== null) {
      const votecandidate = []
      for (let [onevote, candidatelist] of votelist) {
        let aboutvote = {}
        aboutvote.vote = onevote
        for (let [votecode, candidatecode] of props.result) {
          if (votecode === onevote.code) {
            if (candidatecode !== null) {
              for (let onecandidate of candidatelist[0]) {
                if (candidatecode === onecandidate.code) {
                  aboutvote.candidate = onecandidate.name
                }
              }
            } else {
              aboutvote.candidate = null
            }
          }
        }
        votecandidate.push(aboutvote)
      }
      setVote(votecandidate)
    }
    setLoading(false)
  }, [votelist])

  const dialogOpen = () => {
    setDialogOpen(true);
  }

  const dialogClose = () => {
    setDialogOpen(false);
  }

  if (loading === false) {
    return (
      <Fragment>
        <div className={classes.flex}>
          <Grid container spacing={3} className={classes.header}>
            <Grid item xs={12}>
              <Paper elevation={0} className={classes.paperHeader}>
                <h1 style={{color: "black"}}>투표 목록</h1>
                <h2>투표를 선택해주세요.</h2>
              </Paper>
            </Grid>
          </Grid>
          <Grid container spacing={2} className={classes.body}>
            {vote.map((eachvote)=>{
              const changeVoteNumber = (event) => {
                props.setScrollHeight(event.pageY-event.clientY)
                props.setVoteNumber(eachvote.vote.code)
                props.setSelectName(eachvote.candidate)
              }
              if (eachvote.candidate === null) {
                return (
                  <Grid item xs={12} key={eachvote.vote.code}>
                    <Card
                      variant="outlined"
                      onClick={changeVoteNumber}
                      className={classes.cardBody}
                    >
                      <Grid container className={classes.checkbox}>
                        <Grid item xs={2}>
                          <Checkbox />
                        </Grid>
                        <Grid item xs>
                          <CardContent className={classes.cardSpace}>
                            <Typography className={classes.vote}>
                              {eachvote.vote.name}
                            </Typography>
                            <Typography className={classes.candidateNone}>
                              후보를 선택해주세요.
                            </Typography>
                          </CardContent>
                        </Grid>
                        <Grid item xs={2}>
                          <Checkbox style={{visibility: "hidden"}}/>
                        </Grid>
                      </Grid>
                    </Card>
                  </Grid>
                )
              } else {
                return (
                  <Grid item xs={12} key={eachvote.vote.code}>
                    <Card
                      variant="outlined"
                      onClick={changeVoteNumber}
                      className={classes.cardBodySelect}
                    >
                      <Grid container className={classes.checkbox}>
                        <Grid item xs={2} className={classes.votestamp}>
                          <img src={voteStamp} height="25" alt="voteStamp" />
                        </Grid>
                        <Grid item xs>
                          <CardContent className={classes.cardSpace}>
                            <Typography className={classes.vote}>
                              <span className={classes.selectedVote}>{eachvote.vote.name}</span>
                            </Typography>
                            <Typography className={classes.candidate}>
                              <span>{eachvote.candidate}</span>
                            </Typography>
                          </CardContent>
                        </Grid>
                        <Grid item xs={2}>
                          <Checkbox style={{visibility: "hidden"}}/>
                        </Grid>
                      </Grid>
                    </Card>
                  </Grid>
                )
              }
            })}
          </Grid>
          <Grid container spacing={3} className={classes.header}>
            {props.endvote === true ? (
              <Grid item xs={12}>
                <Paper elevation={0} className={classes.paperHeader}>
                  <Button
                    onClick={dialogOpen}
                    variant="contained"
                    color="primary"
                    disableElevation
                    className={classes.submitButton}
                    fullWidth={true}
                  >
                    투표 완료
                  </Button>
                </Paper>
              </Grid>
            ) : (
              <Grid item xs={12}>
                <Paper elevation={0} className={classes.paperHeader}>
                  <p>모든 투표를 완료해 주세요.</p>
                </Paper>
              </Grid>
            )}
          </Grid>
        </div>
        <Dialog
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
          onClose={dialogClose}
          open={dialogopen}
          fullWidth={true}
          maxWidth="xs"
          disableBackdropClick={true}
          PaperProps={{ className: [classes.dialog] }}
        >
          <DialogTitle>
            <div className={classes.textCenter}>
              {props.username}님의 투표 정보
            </div>
          </DialogTitle>
          <DialogContent>
            <Grid container justify="center" >
              <Grid item xs={"auto"}>
                {vote.map((eachvote) => {
                  if (eachvote.candidate === '무효표') {
                    return (
                      <div key={eachvote.vote.code}>
                        {eachvote.vote.name} -> <span className={classes.candidateColor}>무효표</span>
                      </div>
                    )
                  } else {
                    return (
                      <div key={eachvote.vote.code}>
                        {eachvote.vote.name} -> <span className={classes.candidateColor}>{eachvote.candidate}</span> 후보
                      </div>
                    )
                  }
                })}
              </Grid>
            </Grid>
          </DialogContent>
          <DialogActions className={classes.buttonSpace}>
            <Grid container justify="center">
              <Grid item xs={"auto"}>
                <Grid container>
                  <Grid item> 
            <Button
              onClick={props.finishVote}
              variant="contained"
              color="primary"
              fullWidth={true}
              autoFocus
            >
              확인
            </Button>
            </Grid>
            &nbsp;&nbsp;
            <Grid item>
            <Button
              onClick={dialogClose}
              variant="contained"
              color="default"
              fullWidth={true}
              autoFocus
            >
              취소
            </Button>
            </Grid>
            </Grid>
            </Grid>
            </Grid>
          </DialogActions>
        </Dialog>
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

export default UserVoteList;