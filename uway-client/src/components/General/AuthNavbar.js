import React, { useContext, useState } from "react";
import "../../styles/Navbar.css";
import { NAV_LOGO } from "../../assets/logo";
import { MdMenu } from "react-icons/md";
import { Menu, MenuButton, MenuList, MenuItem, Flex } from "@chakra-ui/react";
import { Auth } from "../../context/AuthProvider";
import { LOGOUT } from "../../constants/Auth";
import { useHistory, Link } from "react-router-dom";
import MobileMenu from "./MobileMenu";
import { dashboardRoutes } from "../Dashboard/dashboardRoutes";

const AuthNavbar = (props) => {
  const { dispatch } = useContext(Auth);
  const [toggle, setToggle] = useState(false);
  const history = useHistory();
  const handleLogout = () => {
    dispatch({
      type: LOGOUT,
    });

    history.push("/");
  };

  const handleMobileMenuToggle = () => {
    setToggle((prev) => !prev);
  };
  return (
    <>
      <MobileMenu toggle={toggle} setToggle={setToggle}>
        <Flex flexDirection="column" alignItems="flex-start">
          {dashboardRoutes.map((route, index) => (
            <Link
              key={index}
              to={`/dashboard${route.path}`}
              className="mobile__menu__link"
              onClick={() => setToggle((prev) => !prev)}
            >
              {route.name}
            </Link>
          ))}
          <button className="mobile__menu__link" onClick={handleLogout}>
            Logout
          </button>
        </Flex>
      </MobileMenu>
      <nav className="navbar__wrapper__auth">
        <div className="navbar">
          <div className="navbar__leftSide">
            <div className="navbar__logo">{NAV_LOGO}</div>
          </div>

          <div className="navbar__rightSide">
            <div className="navbar__separator" />
            <Menu>
              <MenuButton className="avatar__wrapper">
                <img
                  alt="user avatar"
                  src={"https://cdn.lessons.com/assets/images/tmp/no_pic.png"}
                />
              </MenuButton>
              <MenuList>
                <MenuItem onClick={handleLogout}>
                  <span> Logout</span>
                </MenuItem>
              </MenuList>
            </Menu>
            <div className="menu__icon__container">
              <MdMenu
                style={{ fontSize: 28 }}
                onClick={handleMobileMenuToggle}
              />
            </div>
          </div>
        </div>
      </nav>
    </>
  );
};

export default AuthNavbar;
