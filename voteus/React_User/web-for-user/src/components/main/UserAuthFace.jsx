import React, { useState, Fragment } from "react";

//custom component
import UserAuthFaceWebcam from "./UserAuthFaceWebcam";

//material-ui
import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import Image from "material-ui-image";
import Grid from "@material-ui/core/Grid";
import CircularProgress from "@material-ui/core/CircularProgress";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import HelpIcon from "@material-ui/icons/Help";
import IconButton from "@material-ui/core/IconButton";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";
import HighlightOffIcon from "@material-ui/icons/HighlightOff";

//image
import captureExam from "../../images/captureExam.png";
import Camera_true from "../../images/Camera_true.png";
import Camera_false1 from "../../images/Camera_false1.png";
import Camera_false2 from "../../images/Camera_false2.png";


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

const UserAuthFace = props => {
  const classes = useStyles();

  const [result, setResult] = useState("face");
  const [open, setOpen] = React.useState(true);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const nextPage = () => {
    props.setNumber(number => number + 1);
  };

  const returnPage = () => {
    setResult("face");
  };

  if (result === "set") {
    return (
      <Fragment>
        <p>인증중...</p>
        <CircularProgress />
      </Fragment>
    );
  } else if (result === "true") {
    return (
      <Fragment>
        <h1>인증에 성공했습니다.</h1>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <Image
              src={captureExam}
              alt="finger-print"
              disableSpinner={true}
              disableTransition={true}
              style={{ height: "200px", paddingTop: 0 }}
              imageStyle={{ width: "auto", position: "static" }}
            />
          </Grid>
          <Grid item xs={12}>
            <p>지문인증절차를 진행합니다.</p>
          </Grid>
          <Grid item xs={12}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              fullWidth={true}
              onClick={nextPage}
            >
              다음
            </Button>
          </Grid>
        </Grid>
      </Fragment>
    );
  } else if (result === "false") {
    return (
      <>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <h1>인증에 실패했습니다.</h1>
          </Grid>
          <Grid item xs={12}>
            <Image
              src={captureExam}
              alt="finger-print"
              disableSpinner={true}
              disableTransition={true}
              style={{ height: "200px", paddingTop: 0 }}
              imageStyle={{ width: "auto", position: "static" }}
            />
          </Grid>
          <Grid item xs={12}>
            <p>상단의 사진을 참고하여 재촬영을 진행해주세요!</p>
          </Grid>
          <Grid item xs={12}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              fullWidth={true}
              onClick={returnPage}
            >
              재촬영
            </Button>
          </Grid>
        </Grid>
      </>
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

        <UserAuthFaceWebcam result={result} setResult={setResult} userinfocode={props.userinfocode}/>
        <Dialog
          open={open}
          onClose={handleClose}
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
          fullWidth={true}
        >
          <DialogTitle id="alert-dialog-title">촬영 전 확인사항</DialogTitle>
          <DialogContent>
            <h2 className={classes.alignCenter}>올바른 촬영 자세</h2>
            <Grid container spacing={1}>
              <Grid container item xs={12} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Camera_true} height="200" alt="투표이미지" />
                </Grid>
              </Grid>
              <Grid container item xs={12} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <CheckCircleOutlineIcon fontSize="large" color="primary" />
                </Grid>
              </Grid>
            </Grid>

            <h2 className={classes.alignCenter}>잘못된 촬영 자세</h2>
            <Grid container spacing={1}>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Camera_false1} height="200" alt="투표이미지" />
                </Grid>
              </Grid>
              <Grid container item xs={6} alignItems="center" justify="center">
                <Grid item xs={"auto"}>
                  <img src={Camera_false2} height="200" alt="투표이미지" />
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

export default UserAuthFace;
