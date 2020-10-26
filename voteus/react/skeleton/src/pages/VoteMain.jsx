import React, { useState, useEffect } from "react";
import Layout from "../layout/Layout";

import Chart from "../components/main/Chart";
import Circle from "../components/main/Circle";
import ActiveVoteList from "../components/main/ActiveVoteList";

import { makeStyles } from "@material-ui/core";

import { ViewContext } from "../context/ViewContext";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import LinearProgress from "@material-ui/core/LinearProgress";
import axios from "axios";

const useStyles = makeStyles(theme => ({
  paper: {
    padding: theme.spacing(2),
    textAlign: "center",
    color: theme.palette.text.secondary
  },
  mh_487: {
    minHeight: 487
  }
}));

const VoteMain = props => {
  const classes = useStyles();

  const [voteData, setVoteData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [selected, setSelected] = React.useState([]);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const token = "Bearer " + sessionStorage.getItem("token");
        const response = await axios({
          method: "GET",
          url: "http://54.180.134.217:8080/api/vote/getVoteActiveList",
          headers: { Authorization: token }
        });
        setVoteData(response.data);
        console.log(response.data);
        if (response.data.length > 0) {
          setSelected([response.data[0].code]);
        }
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  if (loading) {
    return (
      <>
        <LinearProgress />
      </>
    );
  } else {
    return (
      <ViewContext.Provider value={{}}>
        <Layout>
          <Grid container spacing={3}>
            <Grid item xs={12} md={3}>
              <Paper className={classes.paper} style={{ height: 409.5 }}>
                <Circle selected={selected} />
              </Paper>
            </Grid>
            <Grid item xs={12} md={9}>
              <Paper className={classes.paper} style={{ height: 409.5 }}>
                <Chart selected={selected} />
              </Paper>
            </Grid>
            <Grid item xs={12}>
              <Paper className={[classes.paper, classes.mh_487].join(" ")}>
                <ActiveVoteList
                  list={voteData}
                  setSelected={setSelected}
                  selected={selected}
                />
              </Paper>
            </Grid>
          </Grid>
        </Layout>
      </ViewContext.Provider>
    );
  }
};

export default VoteMain;
