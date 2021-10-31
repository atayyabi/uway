import React from "react";
import {
  Alert,
  AlertIcon,
} from "@chakra-ui/react";

const PaymentAlert = () => {
  return (
    <Alert status="info" style={{borderRadius: "10px", fontSize: 12, backgroundColor: "rgba(29, 144, 245, 0.07)"}}>
      <AlertIcon />
      Please ensure your shipment details (weight, dimensions and destination
      address) are accurate to avoid cost adjustments from couriers later.
    </Alert>
  );
};

export default PaymentAlert;
