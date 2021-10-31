import React from "react";
import { Elements } from "@stripe/react-stripe-js";
import { loadStripe } from "@stripe/stripe-js";
import PaymentForm from "./PaymentForm";
import PaymentAlert from "./PaymentAlert";
import { getCarrierIcon } from "./getCarrierIcon";
import { Table, Tbody, Tr, Td, Flex, Thead, Th } from "@chakra-ui/react";
import "../../styles/Dashboard.css";


const stripePromise = loadStripe("pk_test_HVQ1TCXcOZzccJ9pqehIyysu007IjnmAVZ");

const Checkout = ({ step, setStep, selectedRate, formik, setOrderConfirmation }) => {
  return (
    <>
      <div className="ship__card__header">
        <h5>Checkout Information (Step 3 of 3)</h5>
      </div>
      <div className="card ship__card checkout">
        <PaymentAlert />

        <Table size="md" style={{ margin: "10px 0 20px 0" }}>
          <Thead>
            <Tr>
              <Th>Order Summary</Th>
              <Th isNumeric>Total Charge</Th>
            </Tr>
          </Thead>
          <Tbody>
            <Tr className="">
              <Td>
                {" "}
                <Flex alignItems="center">
                  <div className="results__icon">
                    {getCarrierIcon(selectedRate?.carrierName)}
                  </div>
                  <div>
                    {selectedRate?.carrierName} - {selectedRate?.serviceName}
                  </div>
                </Flex>
              </Td>

              <Td isNumeric>{selectedRate?.totalCharge}</Td>
            </Tr>
          </Tbody>
        </Table>

        <Elements stripe={stripePromise}>
          <PaymentForm step={step} setStep={setStep} selectedRate={selectedRate} formik={formik} setOrderConfirmation={setOrderConfirmation}/>
        </Elements>
      </div>
    </>
  );
};

export default Checkout;
