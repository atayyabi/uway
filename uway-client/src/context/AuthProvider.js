import React, { useReducer, createContext } from "react";
import { reducer } from "../reducers/auth";

const initialState = {
  user: null,
  token: null,
  isAuthenticated: false,
  isLoading: true
};
export const Auth = createContext(initialState);

const AuthProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return <Auth.Provider value={{ state, dispatch }}>{children}</Auth.Provider>;
};

export default AuthProvider;
