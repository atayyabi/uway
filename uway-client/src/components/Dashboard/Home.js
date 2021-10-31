import React, { useContext, useEffect, useState } from "react";
import "../../styles/Dashboard.css";
import DashboardExplore from "./DashboardExplore";
import DashboardGetStarted from "./DashboardGetStarted";
import DashboardViewOrders from "./DashboardViewOrders";
import DashboardSummary from "./DashboardSummary";
import { Auth } from "../../context/AuthProvider";
import { getOrders } from "../../api/User";
import { CircularProgress } from "@chakra-ui/react";

const Home = () => {
  const { state: authState } = useContext(Auth);
  const userName = authState.user?.fullName;
  const [isLoading, setIsLoading] = useState(false);
  const [orders, setOrders] = useState([]);


  useEffect(() => {
    setIsLoading(true);
    getOrders()
      .then((res) => {
        console.log(res);
        setOrders(res);
      })
      .then(() => {
        setIsLoading(false);
      })
      .catch((e) => {
        setIsLoading(false);
      });
  }, []);

  return (
    <>
      {isLoading ? (
        <CircularProgress
          isIndeterminate
          style={{ position: "absolute", top: "45%", right: "45%" }}
        />
      ) : (
        <div className="dashboard__section__wrapper">
          <div className="section__header">
            <h1 className="ship__page__heading">Hi {userName}, </h1>
            <p className="ship__page__subhead">Welcome to your dashboard.</p>
          </div>
          <div className="dashboard__main__section">
            <div className="section__main">
              <DashboardGetStarted />
              <DashboardViewOrders data={orders}/>
              <DashboardExplore />
            </div>
            <div className="section__side">
              <DashboardSummary data={orders}/>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Home;
