import React, { useState } from "react";
import Layout from "../layout/Layout";

import { makeStyles } from "@material-ui/core";

import PartyTable from "../components/party/PartyTable";

import { ViewContext } from "../context/ViewContext";

const useStyles = makeStyles(theme => ({}));

const PartyList = props => {
  const classes = useStyles();

  return (
    <ViewContext.Provider value={{}}>
      <Layout>
        <PartyTable />
      </Layout>
    </ViewContext.Provider>
  );
};

export default PartyList;
