import React, { useContext, useState, Fragment, useRef } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Webcam from "react-webcam";
import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";

import axios from "axios";

import UserNameContext from "../../context/UserNameContext";

const useStyles = makeStyles(theme => ({
  m_b_10: {
    marginBottom: "10px"
  },
  mh_600: {
    minHeight: "600px"
  },
  warning: {
    marginBottom: theme.spacing(1)
  },
  h2margin: {
    margin: theme.spacing(2)
  }
}));

const videoConstraints = {
  width: 600,
  height: 600,
  facingMode: "user"
};

const UserAuthWebcam = props => {
  const classes = useStyles();

  const [screenshot, setScreenShot] = useState("");
  const [buttondisabled, setButtonDisabled] = useState(true);

  const username = useContext(UserNameContext);

  const webcamRef = React.useRef(null);

  const capture = React.useCallback(() => {
    setButtonDisabled(true)
    setTimeout(() => {setButtonDisabled(false)}, 500)

    if (
      webcamRef.current.stream !== null &&
      webcamRef.current.stream !== undefined
    ) {
      const imageSrc = webcamRef.current.getScreenshot();
      setScreenShot(screenshot => imageSrc);
    }
  }, [webcamRef]);

  const reset = React.useCallback(() => {
    setScreenShot("");
  }, []);

  const save = useRef(null);

  const send = () => {
    props.setResult("set");
    setTimeout(() => {
      sendFace();
    }, 500);
  };

  const sendFace = () => {
    axios
      .post("http://192.168.100.121:5000/getImg", {
        img: screenshot,
        name: props.userinfocode
      })
      .then(res => {
        if (res.data.code === "00") {
          props.setResult("true");
        } else {
          props.setResult("false");
        }
      })
      .catch(error => console.log(error));
  };

  return (
    <Fragment>
      {screenshot ? (
        <>
          <h2 className={classes.h2margin}>촬영된 사진을 확인하신 후</h2>
          <h2 className={classes.h2margin}>인증 또는 재촬영을 진행해주세요.</h2>
        </>
      ) : (
        <>
          <h2 className={classes.h2margin}>{username}님 인증 절차를 진행합니다.</h2>
          <h2 className={classes.h2margin}>카메라를 응시 후 촬영을 진행해주세요.</h2>
        </>
      )}
      <Grid container>
        <Grid item xs={12} className={classes.mh_600}>
          {screenshot === "" && (
            <div>
              <Webcam
                audio={false}
                ref={webcamRef}
                screenshotFormat="image/jpeg"
                width="100%"
                videoConstraints={videoConstraints}
                onClick={capture}
              />
            </div>
          )}
          {screenshot ? (
            <img src={screenshot} alt="screenshot" ref={save} />
          ) : null}
        </Grid>
        {screenshot ? (
          buttondisabled === true ? (
            <>
              <Grid item xs={12}>
                <div style={{color: "white"}} className={classes.warning}>(카메라를 터치해도 촬영 가능합니다.)</div>
              </Grid>
              <Grid container spacing={1}>
                <Grid item xs={6}>
                  <Button
                    variant="contained"
                    size="large"
                    color="primary"
                    fullWidth={true}
                    onClick={send}
                    disabled
                  >
                    인증
                  </Button>
                </Grid>
                <Grid item xs={6}>
                  <Button
                    variant="contained"
                    size="large"
                    color="primary"
                    fullWidth={true}
                    onClick={reset}
                    disabled
                  >
                    재촬영
                  </Button>
                </Grid>
              </Grid>
            </>
          ):(
            <>
              <Grid item xs={12}>
                <div style={{color: "white"}} className={classes.warning}>(카메라를 터치해도 촬영 가능합니다.)</div>
              </Grid>
              <Grid container spacing={1}>
                <Grid item xs={6}>
                  <Button
                    variant="contained"
                    size="large"
                    color="primary"
                    fullWidth={true}
                    onClick={send}
                  >
                    인증
                  </Button>
                </Grid>
                <Grid item xs={6}>
                  <Button
                    variant="contained"
                    size="large"
                    color="primary"
                    fullWidth={true}
                    onClick={reset}
                  >
                    재촬영
                  </Button>
                </Grid>
              </Grid>
            </>
          )
        ) : (
          <>
            <Grid item xs={12}>
              <div className={classes.warning}>(카메라를 터치해도 촬영 가능합니다.)</div>
            </Grid>
            <Grid item xs={12}>
              <Button
                variant="contained"
                size="large"
                color="primary"
                fullWidth={true}
                onClick={capture}
              >
                촬영
              </Button>
            </Grid>
          </>
        )}
      </Grid>
    </Fragment>
  );
};

export default UserAuthWebcam;
