import React, { useState, Fragment } from "react";
import UserAuthComplete from "./UserAuthComplete";
import UserAuthFingerRecognition from "../main/UserAuthFingerRecognition";

import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
// import { Link } from "@material-ui/core";
import { Link } from 'react-router-dom';
import Grid from "@material-ui/core/Grid";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import HelpIcon from "@material-ui/icons/Help";
import IconButton from "@material-ui/core/IconButton";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";
import HighlightOffIcon from "@material-ui/icons/HighlightOff";
import CircularProgress from "@material-ui/core/CircularProgress";

import axios from 'axios';

//image
import Fingerprint_true from "../../images/Fingerprint_true.png";
import Fingerprint_false1 from "../../images/Fingerprint_false1.png";
import Fingerprint_false2 from "../../images/Fingerprint_false2.png";

const useStyles = makeStyles(theme => ({
  bold: {
    fontWeight: "bold"
  },
  alignCenter: {
    textAlign: "center"
  },
  dialogMargin: {
    marginTop: theme.spacing(3)
  }
}));

const UserAuthFinger = props => {
  const classes = useStyles();
  const [fingerprint, setFingerPrint] = useState("");
  const [result, setResult] = useState("picture");
  const [open, setOpen] = React.useState(true);
  const [countdown, setCountDown] = useState(15);
  const [wait, setWait] = useState(null)

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {

    const down = () => {
      console.log(countdown)
      setCountDown(countdown => countdown - 1)
    }
    let timer = setInterval(down, 1000);

    setTimeout(function(){
      clearInterval(timer)
      setWait("wait")
    }, 15001)

    const takePicture = async () => {
      try {
        const res = await axios.post(
          'http://192.168.100.121:5000/getFinger'
        )
        console.log(res.data)
        if (res.data.code === "00") {
          clearInterval(timer)
          setCountDown(15)
          setWait(null)
          setFingerPrint(res.data.img)
        } else {
          clearInterval(timer)
          setCountDown(15)
          setWait(null)
          setResult("problem")
        }
      } catch (error) {
        console.log(error)
      }
    }
    takePicture()

    setOpen(false);
  };

  const returnPage = () => {
    setFingerPrint("")
    setWait(null)
    setResult("picture")

    const down = () => {
      console.log(countdown)
      setCountDown(countdown => countdown - 1)
    }
    let timer = setInterval(down, 1000);

    setTimeout(function(){
      clearInterval(timer)
      setWait("wait")
    }, 15001)

    const takePicture = async () => {
      try {
        const res = await axios.post(
          'http://192.168.100.121:5000/getFinger'
        )
        console.log(res.data)
        if (res.data.code === "00") {
          clearInterval(timer)
          setCountDown(15)
          setWait(null)
          setFingerPrint(res.data.img)
        } else {
          clearInterval(timer)
          setCountDown(15)
          setWait(null)
          setResult("problem")
        }
      } catch (error) {
        console.log(error)
      }
    }
    takePicture()
  };

  const clear = () => {
    sessionStorage.clear();
  }

  if (result === "problem") {
    return (
      <Fragment>
        <h2>지문 인증에 문제가 발생하였습니다.</h2>
        <h2>관리자에게 문의해주세요.</h2>
        <Link to="/">
          <Button
            variant="contained"
            size="large"
            color="primary"
            onClick={clear}
          >
            돌아가기
          </Button>
        </Link>
      </Fragment>
    );
  } else if (result === "wait") {
    return (
      <Fragment>
        <CircularProgress />
      </Fragment>
    )
  } else if (result === "set") {
    return (
      <Fragment>
        <h2>지문 인증중입니다.</h2>
        <h2>잠시만 기다려주세요.</h2>
        <CircularProgress />
      </Fragment>
    )
  } else if (result === "true") {
    return (
      <Fragment>
        <UserAuthComplete
          returnPage={returnPage}
          userinfocode={props.userinfocode}
        />
      </Fragment>
    );
  } else if (result === "false") {
    return (
      <Fragment>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <h1>인증에 실패했습니다.</h1>
          </Grid>
          <Grid item xs={12}>
            <p>지문인증을 다시 진행해주세요!</p>
          </Grid>
          <Grid item xs={12}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              fullWidth={true}
              onClick={returnPage}
            >
              다시하기
            </Button>
          </Grid>
        </Grid>
      </Fragment>
    );
  } else {
    return (
      <Fragment>
        <IconButton
          color="secondary"
          aria-label="도움말"
          onClick={handleClickOpen}
        >
          <HelpIcon fontSize="large" />
          도움말
        </IconButton>
        <UserAuthFingerRecognition
          result={result}
          setResult={setResult}
          fingerprint={fingerprint}
          setFingerPrint={setFingerPrint}
          countdown={countdown}
          setCountDown={setCountDown}
          wait={wait}
          setWait={setWait}
          userinfocode={props.userinfocode}
        />
        <Dialog
          open={open}
          onClose={handleClose}
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
          fullWidth={true}
        >
          <DialogTitle id="alert-dialog-title">
            지문인식 전 확인사항
          </DialogTitle>
          <DialogContent>
            <h2 className={classes.alignCenter}>올바른 지문인식</h2>
            <Grid container spacing={1}>
              <Grid container item xs={12} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Fingerprint_true} height="200" alt="지문" />
                </Grid>
              </Grid>
              <Grid container item xs={12} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <CheckCircleOutlineIcon fontSize="large" color="primary" />
                </Grid>
              </Grid>
            </Grid>

            <h2 className={classes.alignCenter}>잘못된 지문인식</h2>
            <Grid container spacing={1}>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Fingerprint_false1} height="200" alt="지문" />
                </Grid>
              </Grid>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Fingerprint_false2} height="200" alt="지문" />
                </Grid>
              </Grid>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <HighlightOffIcon fontSize="large" color="secondary" />
                </Grid>
              </Grid>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <HighlightOffIcon fontSize="large" color="secondary" />
                </Grid>
              </Grid>
            </Grid>
          </DialogContent>
          <DialogActions>
            <Button
              variant="contained"
              size="large"
              color="primary"
              fullWidth={true}
              onClick={handleClose}
              autoFocus
              className={classes.dialogMargin}
            >
              확인
            </Button>
          </DialogActions>
        </Dialog>
      </Fragment>
    );
  }
};

export default UserAuthFinger;
