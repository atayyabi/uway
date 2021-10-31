import React from 'react'
import "../../styles/Dashboard.css"
import { IoIosArrowForward } from "react-icons/io";

const DashboardExplore = () => {
    return (
        <div className="card marg-top">
            <div className="explore__uway__card">
              <h3>Explore Uway</h3>
              <p className="get__started__text">Check out how we can help you with your shipping needs</p>
            </div>
            <div className="explore__uway__links">
              <button className="explore__link">
                Browse our FAQ
                <IoIosArrowForward className="explore__icon" />
              </button>
              <button className="explore__link">
                Browse our features
                <IoIosArrowForward className="explore__icon" />
              </button>
              <button className="explore__link">
                Browse our carriers
                <IoIosArrowForward className="explore__icon" />
              </button>
            </div>
          </div>
    )
}

export default DashboardExplore
