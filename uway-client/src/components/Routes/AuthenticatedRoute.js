import React, {useContext} from "react";
import { Route, Redirect, useLocation } from "react-router-dom";
import AuthNavbar from "../General/AuthNavbar";
import { Auth } from "../../context/AuthProvider";


const AuthenticatedRoute = (props) => {
  const location = useLocation();
  const { state: authState } = useContext(Auth);

  return authState.isAuthenticated ? (
    <>
      <AuthNavbar {...props} />
      <Route {...props} />
    </>
  ) : (
    <Redirect
      to={{
        pathname: "/login",
        state: { from: location },
      }}
    />
  );
};

export default AuthenticatedRoute;
