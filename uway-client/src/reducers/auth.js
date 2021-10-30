import { LOGIN, LOGOUT } from "../constants/Auth";

export const reducer = (state, action) => {
  switch (action.type) {
    case LOGIN:
      localStorage.setItem("token", JSON.stringify(action.payload.jwt));
      return {
        ...state,
        isAuthenticated: true,
        user: action.payload.user,
        token: action.payload.jwt

      };
    case LOGOUT:
      localStorage.clear();
      return {
        ...state,
        user: null,
        token: null,
        isAuthenticated: false,
      };
    default:
      return state;
  }
};
