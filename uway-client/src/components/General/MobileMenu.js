import React from "react";
import "../../styles/Navbar.css";
import { MdClose } from "react-icons/md";

const MobileMenu = ({ toggle, setToggle, children }) => {
  return (
    <>
      {toggle && (
        <div
          className="mobile__menu"
          style={
            toggle
              ? {
                  transform: "translateX(0%)",
                }
              : { transform: "translateX(100%)" }
          }
        >
          <button
            className="close__btn close__icon__container"
            onClick={() => setToggle((prev) => !prev)}
          >
            <MdClose style={{ fontSize: 20 }} />
          </button>
          <div className="menu__content">{children}</div>
        </div>
      )}
    </>
  );
};

export default MobileMenu;
