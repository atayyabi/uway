import React from "react";
import "../../styles/Dashboard.css";

const DashboardSummary = ({ data }) => {
  return (
    <div className="card">
      <div className="explore__uway__card">
        <h3>Shipment Summary</h3>
        <div className="summary__section__container">
          <div className="summary__section">
            <h5>Shipping costs</h5>
            <div className="summary__data">
              <p>Total</p>
              <p>
                ${" "}
                {data
                  ? data
                      .reduce((a, v) => (a = a + v.totalCharge / 100), 0)
                      .toFixed(2)
                  : "-"}
              </p>
            </div>
          </div>
          <div className="summary__section">
            <h5>Average cost per shipment</h5>
            <div className="summary__data">
              <p>Total</p>
              <p>
                ${" "}
                {data
                  ? (
                      data.reduce((a, v) => (a = a + v.totalCharge / 100), 0) /
                      data.length
                    ).toFixed(2)
                  : "-"}
              </p>
            </div>
          </div>
          <div className="summary__section">
            <h5>Number of shipments</h5>
            <div className="summary__data">
              <p>Total</p>
              <p>{data ? data.length + " Shipment(s)" : "-"}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DashboardSummary;
