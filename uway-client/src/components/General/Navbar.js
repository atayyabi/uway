import React from "react";
import "../../styles/Navbar.css";
import { NAV_LOGO } from "../../assets/logo";
import { Link } from "react-router-dom";


const Navbar = () => {

  return (
    <nav className="navbar__wrapper">
      <div className="navbar navbar__home">
        <div className="navbar__leftSide">
          <Link className="navbar__logo" to="/">{NAV_LOGO}</Link>
        </div>

        <div className="navbar__rightSide">
          <>
            <div className="navbar__auth">
              <Link className="navbar__login" to="/login">
                {" "}
                Sign in
              </Link>
              <Link className="navbar__signup" to="/signup">
                Sign up
              </Link>
            </div>
          </>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
