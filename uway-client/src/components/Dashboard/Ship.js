import React, { useState } from "react";
import { Formik, Form } from "formik";
import ShipForm from "./ShipForm";
import Rates from "./Rates";
import Checkout from "./Checkout";
import { getQuote } from "../../api/Eshipper";
// import {
//   generateDomesticValues,
//   generateInternationalValues,
// } from "./testValues";
import { useLocation } from "react-router-dom";
import Confirmation from "./Confirmation";

var jsonxml = require("jsontoxml");

const initialValues = {
  from: {
    company: "",
    address1: "",
    address2: "",
    country: "CA",
    zip: "",
    state: "",
    city: "",
    phone: "",
    email: "",
  },
  to: {
    company: "",
    address1: "",
    address2: "",
    country: "",
    zip: "",
    state: "",
    city: "",
    phone: "",
    email: "",
    isResidential: false,
  },
  orderSummary: {
    type: "package",
    length: "",
    width: "",
    height: "",
    weight: "",
  },
};

const getStepContent = (
  step,
  setStep,
  formik,
  quotes,
  isLoading,
  selectedRate,
  setSelectedRate,
  activeIndex,
  setActiveIndex,
  orderConfirmation,
  setOrderConfirmation
) => {
  switch (step) {
    case 1:
      return (
        <ShipForm
          step={step}
          setStep={setStep}
          formik={formik}
          isLoading={isLoading}
        />
      );
    case 2:
      return (
        <Rates
          step={step}
          setStep={setStep}
          formik={formik}
          quotes={quotes}
          selectedRate={selectedRate}
          setSelectedRate={setSelectedRate}
          activeIndex={activeIndex}
          setActiveIndex={setActiveIndex}
        />
      );
    case 3:
      return (
        <Checkout
          step={step}
          setStep={setStep}
          formik={formik}
          selectedRate={selectedRate}
          setOrderConfirmation={setOrderConfirmation}
        />
      );
    case 4:
      return (
        <Confirmation 
        orderConfirmation={orderConfirmation}
        />
      )
    default:
      return null;
  }
};

const Ship = () => {
  const [step, setStep] = useState(1);
  const [isLoading, setIsLoading] = useState(false);
  const location = useLocation();
  const [quotes, setQuotes] = useState([]);
  const [selectedRate, setSelectedRate] = useState(
    location?.state?.quoteRate ? location.state.quoteRate : {}
  );
  const [activeIndex, setActiveIndex] = useState(
    location?.state?.activeIndex ? location.state.activeIndex : ""
  );

  const [orderConfirmation, setOrderConfirmation] = useState({});

  const handleStepOneSubmit = (values) => {
    const payload = {
      QuoteRequest: {
        From: {
          id: "1",
          company: "sender",
          address1: values.from.address1,
          address2: values.from.address2,
          city: values.from.city,
          state: values.from.state,
          country: values.from.country,
          zip: values.from.zip,
        },
        To: {
          company: "receiver",
          address1: values.to.address1,
          address2: values.to.address2,
          city: values.to.city,
          state: values.to.state,
          country: values.to.country,
          zip: values.to.zip,
          residential: values.to.isResidential,
        },
        Packages: {
          type: values.orderSummary.type,
          Package: {
            length: values.orderSummary.length,
            width: values.orderSummary.width,
            height: values.orderSummary.height,
            weight: values.orderSummary.weight,
          },
        },
      },
    };
    const data = jsonxml(payload);
    setIsLoading(true);
    getQuote(data)
      .then((res) => {
        console.log(res.quoteReply.quote);
        setQuotes(res.quoteReply.quote);
      })
      .then(() => setIsLoading(false))
      .then(() => setStep(step + 1))
      .catch((e) => {
        setIsLoading(false);
        console.log(e);
      });
  };

  
  return (
    <div className="dashboard__section__wrapper">
      <div className="ship__section">
        <div className="ship__card__header">
          <h3 className="ship__page__heading">
            Book a <span>shipment</span>
          </h3>
        </div>
        <Formik
          initialValues={
            location?.state?.state
              ? location.state.state
              : initialValues
          }
          onSubmit={(values) => handleStepOneSubmit(values)}
        >
          {(formik) => (
            <Form>
              {getStepContent(
                step,
                setStep,
                formik,
                quotes,
                isLoading,
                selectedRate,
                setSelectedRate,
                activeIndex,
                setActiveIndex,
                orderConfirmation,
                setOrderConfirmation
              )}
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default Ship;
