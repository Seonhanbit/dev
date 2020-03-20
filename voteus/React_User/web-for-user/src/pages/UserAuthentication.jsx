import React, { Fragment } from "react";

import UserHeader from "../layout/UserHeader";
import UserAuthBody from "../layout/UserAuthBody";
import UserFooter from "../layout/UserFooter";
import FlexPaperTemplate from "../components/main/FlexPaperTemplate";

import TypeContext from "../context/TypeContext";

const UserAuthentication = props => {

  return (
    <Fragment>
      <TypeContext.Provider value={'auth'}>
        <UserHeader />
      </TypeContext.Provider>
      <FlexPaperTemplate>
        <UserAuthBody />
      </FlexPaperTemplate>
      <UserFooter />
    </Fragment>
  );
};

export default UserAuthentication;
