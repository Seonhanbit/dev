import React, { useState, useEffect } from "react";
import Layout from "../layout/Layout";

import { makeStyles } from "@material-ui/core";

import VoterTable from "../components/voter/VoterTable";

import { ViewContext } from "../context/ViewContext";

import LinearProgress from "@material-ui/core/LinearProgress";

import axios from "axios";

const useStyles = makeStyles(theme => ({}));

const VoterList = props => {
  const classes = useStyles();

  const [state, setState] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(
          "http://54.180.134.217:8080/api/area/getAreaAllList"
        );
        setState(response.data);
        console.log(response.data);
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
  }

  return (
    <ViewContext.Provider value={{}}>
      <Layout>
        <VoterTable areaCode={state} />
      </Layout>
    </ViewContext.Provider>
  );
};

export default VoterList;
