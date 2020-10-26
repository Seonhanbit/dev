import React, { useState, useEffect } from "react";
import Layout from "../layout/Layout";

import { makeStyles } from "@material-ui/core";

import AreaTable from "../components/area/AreaTable";

import { ViewContext } from "../context/ViewContext";
import LinearProgress from "@material-ui/core/LinearProgress";

import axios from "axios";

const useStyles = makeStyles(theme => ({}));

const AreaList = () => {
  const classes = useStyles();

  return (
    <ViewContext.Provider value={{}}>
      <Layout>
        <AreaTable />
      </Layout>
    </ViewContext.Provider>
  );
};

export default AreaList;
