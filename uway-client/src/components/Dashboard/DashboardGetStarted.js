import React from 'react'
import { VIEW_ORDERS } from "../../assets/images";
import { FaBoxOpen } from "react-icons/fa";
import { BsFillCalculatorFill } from "react-icons/bs";
import {useHistory} from "react-router-dom";
import { IoIosArrowForward } from "react-icons/io";

const DashboardGetStarted = () => {
    const history = useHistory();

    return (
        <div className="card">
            <div className="get__started__card">
              <h3 className="get__started__header">Let's get started</h3>
              <p className="get__started__text">
                What would you like to do first?
              </p>
            </div>
            <div className="get__started__main">
              <span className="get__started__img">{VIEW_ORDERS}</span>
              <div className="get__started__btns">
                <button className="ship__btn create" onClick={() => history.push("/dashboard/ship")}>
                  <div className="ship__btn__inner">
                    <FaBoxOpen className="get__started__icon" />
                    Create a shipment
                  </div>

                  <IoIosArrowForward className="explore__icon" />
                </button>
                <button className="ship__btn quote" onClick={() => history.push("/dashboard/quote")}>
                  <div className="ship__btn__inner">
                    <BsFillCalculatorFill className="get__started__icon" />
                    Get a quote
                  </div>

                  <IoIosArrowForward className="explore__icon" />
                </button>
              </div>
            </div>

            <div></div>
          </div>
    )
}

export default DashboardGetStarted
