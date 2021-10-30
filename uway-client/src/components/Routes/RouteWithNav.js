import React from "react";
import { Route } from "react-router-dom";
import Navbar from "../General/Navbar";

const RouteWithNav = ({ exact, path, component: Component, ...rest }) => {
  return (
    <>
      <Route
        exact={exact}
        path={path}
        {...rest}
        render={(routeProps) => {
          return (
            <>
              <Navbar {...routeProps} />
              <Component {...routeProps} />
            </>
          );
        }}
      />
    </>
  );
};

export default RouteWithNav;
