import React from "react";
import { Route, Redirect } from "react-router-dom";

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      sessionStorage.getItem("token") ? (
        <Component {...props} />
      ) : (
        <Redirect
          to={{ pathname: "/SignInSide", state: { from: props.location } }}
        />
      )
    }
  />
);
export default PrivateRoute;
