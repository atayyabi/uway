import React from "react";
import "../../styles/Dashboard.css";
import { Flex } from "@chakra-ui/react";
import {ORDER_CONF} from "../../assets/images";

// const order = {
//   id: "123456",
//   carrierName: "Federal Express",
//   carrierService: "Fedex Ground",
//   trackingNumber: "794678198903",
//   trackingUrl: "https://www.fedex.com/fedextrack/?trknbr=794678198903",
// };

const Confirmation = ({ orderConfirmation }) => {
  return (
    <div className="card ship__card checkout">
      <h5 className="confirmation__header">Order Confirmation</h5>
      <Flex>
        <Flex padding="10px 0" flexDirection="column">
          <p>Order #: {orderConfirmation.id}</p>
          <p>Carrier: {orderConfirmation.carrierName}</p>
          <p>Service: {orderConfirmation.carrierService}</p>
          <p>Tracking Number: {orderConfirmation.trackingNumber}</p>
          <p>
            Tracking Url: <a href={orderConfirmation.trackingUrl}>{orderConfirmation.trackingUrl}</a>
          </p>
        </Flex>
        <Flex padding="10px" justifyContent="flex-start">
            <div className="conf__img">
                {ORDER_CONF}
            </div>
        </Flex>
      </Flex>
    </div>
  );
};

export default Confirmation;
