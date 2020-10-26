import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Link from "@material-ui/core/Link";
import Paper from "@material-ui/core/Paper";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import { Alert, AlertTitle } from "@material-ui/lab";
import axios from "axios";

function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      Copyright © 25+2d corp. all rights reserved
    </Typography>
  );
}

const useStyles = makeStyles(theme => ({
  root: {
    height: "100vh"
  },
  image: {
    // backgroundImage: "url(https://source.unsplash.com/random)",
    backgroundImage: "url(img/votelogo.png)",
    backgroundRepeat: "no-repeat",
    backgroundColor:
      theme.palette.type === "dark"
        ? theme.palette.grey[900]
        : theme.palette.grey[50],
    backgroundSize: "cover",
    backgroundPosition: "center"
  },
  paper: {
    margin: theme.spacing(8, 4),
    display: "flex",
    flexDirection: "column",
    alignItems: "center"
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1)
  },
  submit: {
    margin: theme.spacing(3, 0, 2)
  }
}));

export default function SignInSide(props) {
  const classes = useStyles();
  const [id, setId] = React.useState(null);
  const [pw, setPw] = React.useState(null);
  const [loginFail, setLoginFail] = React.useState(false);

  const updateId = e => {
    setId(e.target.value);
  };

  const updatePw = e => {
    setPw(e.target.value);
  };

  const loginfunc = event => {
    event.preventDefault();
    const token = sessionStorage.getItem("token");

    axios
      .post(
        "http://54.180.134.217:8080/authenticate",
        JSON.stringify({ username: id, password: pw }),
        {
          headers: {
            "Content-Type": "application/json"
          }
        }
      )
      .then(ret => {
        console.log(ret.data.token);
        sessionStorage.setItem("token", ret.data.token);
        props.history.push("/VoteMain");
      })
      .catch(error => {
        console.log(error);
        setLoginFail(true);
        props.history.push("/SignInSide");
      });
  };

  return (
    <Grid container component="main" className={classes.root}>
      <CssBaseline />
      <Grid item xs={false} sm={4} md={7} className={classes.image} />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <div className={classes.paper}>
          <Avatar className={classes.avatar}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            VOTE US ADMIN
          </Typography>
          <form className={classes.form} noValidate onSubmit={loginfunc}>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="id"
              label="ID"
              name="email"
              autoComplete="off"
              autoFocus
              onChange={updateId}
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
              onChange={updatePw}
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="아이디 기억"
            />
            {loginFail ? (
              <Alert severity="error">
                <AlertTitle>로그인 실패</AlertTitle>
                아이디 또는 비밀번호를 확인해주세요.
              </Alert>
            ) : null}

            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
            >
              로그인
            </Button>
            <Box mt={5}>
              <Copyright />
            </Box>
          </form>
        </div>
      </Grid>
    </Grid>
  );
}
