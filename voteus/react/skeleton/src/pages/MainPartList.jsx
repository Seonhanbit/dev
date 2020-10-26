import React, { useState } from "react";
import Layout from "../layout/Layout";

import { makeStyles } from "@material-ui/core";

import MainPartTable from "../components/mainpart/MainPartTable";

import { ViewContext } from "../context/ViewContext";

const useStyles = makeStyles(theme => ({}));

const MainPartList = props => {
  const classes = useStyles();

  return (
    <ViewContext.Provider value={{}}>
      <Layout>
        <MainPartTable />
      </Layout>
    </ViewContext.Provider>
  );
};

export default MainPartList;
