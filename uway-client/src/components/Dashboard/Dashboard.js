import React from "react";
import { Switch, Route, NavLink, useRouteMatch } from "react-router-dom";
import Ship from "./Ship";
import Account from "./Account";
import Orders from "./Orders";
import "../../styles/Dashboard.css";
import Home from "./Home";
import { dashboardRoutes } from "./dashboardRoutes";
import Quote from "./Quote";
import { BsQuestionCircle } from "react-icons/bs";




const Dashboard = () => {
  let { url } = useRouteMatch();
  

  return (
    <div className="dashboard">
      <div className="dashboard__container">
        <div className="dashboard__menu">
          <div className="dashboard__menu__list">
            {dashboardRoutes.map((route, index) => (
              <NavLink
                key={index}
                to={`${url}${route.path}`}
                className="sidenav__item"
                activeClassName="sidenav__item__active"
              >
                <div className="sidenav__link">
                  <span className="sidenav__icon">{route.icon}</span>
                  <span className="sidenav__name">{route.name}</span>
                </div>
              </NavLink>
            ))}
          </div>
          <div className="sidenav__support">
            <div className="support__footer">
              <p>Got Questions?</p>
              <p>We got Answers</p>
            </div>
            <button className="sidenav__support__btn">
              <div className="supp__btn__content">
                <BsQuestionCircle style={{ fontSize: 16 }} />
                <span className="supp__btn__text">FAQs</span>
              </div>
            </button>
          </div>
        </div>
        <div className="dashboard__main">
          <div className="dashboard__main__content">
            <Switch>
              <Route path={`${url}/home`} exact component={Home} />
              <Route path={`${url}/orders`} exact component={Orders} />
              <Route path={`${url}/account`} exact component={Account} />
              <Route path={`${url}/ship`} exact component={Ship} />
              <Route path={`${url}/quote`} exact component={Quote} />
            </Switch>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
