import React, { useState } from "react";
import { useStripe, useElements, CardElement } from "@stripe/react-stripe-js";
import "../../styles/Dashboard.css";
import { charge } from "../../api/Eshipper";
import { CircularProgress } from "@chakra-ui/react";

var jsonxml = require("jsontoxml");

const PaymentForm = ({
  step,
  setStep,
  formik,
  selectedRate,
  setOrderConfirmation,
}) => {
  const stripe = useStripe();
  const elements = useElements();
  const [isLoading, setIsLoading] = useState(false);
  const values = formik.values;
  const shippingRequest = {
    From: {
      id: "1",
      company: values.from.company,
      address1: values.from.address1,
      city: values.from.city,
      state: values.from.state,
      zip: values.from.zip,
      country: values.from.country,
      phone: values.from.phone,
      attention: values.from.company,
      email: values.from.email,
    },
    To: {
      company: values.to.company,
      address1: values.to.address1,
      city: values.to.city,
      state: values.to.state,
      zip: values.to.zip,
      country: values.to.country,
      attention: values.to.company,
      residential: values.to.isResidential,
      phone: values.to.phone || values.from.phone,
    },

    Packages: {
      Package: {
        length: values.orderSummary.length,
        width: values.orderSummary.width,
        height: values.orderSummary.height,
        weight: values.orderSummary.height,
      },
      type: values.orderSummary.type,
    },

    serviceId: selectedRate.serviceId,
    stackable: true,
  };

  const handleCheckout = async (event) => {
    event.preventDefault();
    setIsLoading(true);

    if (!stripe || !elements) {
      return;
    }

    const card = elements.getElement(CardElement);
    const result = await stripe.createToken(card);
    console.log(result);

    if (result.error) {
      console.log(result.error.message);
    } else {
      stripeTokenHandler(result.token);
    }

    async function stripeTokenHandler(token) {
      const payload = {
        ShippingRequestWrapper: {
          ShippingRequest: shippingRequest,
          StripeToken: token.id,
        },
      };

      const data = jsonxml(payload);
      console.log(data);
      charge(data)
        .then((res) => {
          setOrderConfirmation(res);
        })
        .then(() => {
          setIsLoading(false);
          setStep(step + 1);
        })
        .catch((e) => {
          setIsLoading(false);
        });
    }
  };
  return (
    <>
      <label className="payment__label">Credit Card Details</label>
      <div className="payment__form">
        <CardElement />
      </div>
      <div className="quote__btn__container">
        <button className="back__btn" onClick={() => setStep(step - 1)}>
          Back
        </button>
        <button className="quote__btn " onClick={handleCheckout}>
          {isLoading ? (
            <CircularProgress
              isIndeterminate
              size={15}
              style={{ padding: "0px 33px" }}
            />
          ) : (
            "Submit"
          )}
        </button>
      </div>
    </>
  );
};

export default PaymentForm;
