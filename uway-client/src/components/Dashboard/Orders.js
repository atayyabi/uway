import React, { useState, useEffect } from "react";
import "../../styles/Dashboard.css";
import {
  Flex,
  Table,
  Th,
  Tr,
  Thead,
  Tbody,
  Td,
  CircularProgress,
} from "@chakra-ui/react";
import { getOrders } from "../../api/User";
import { getCarrierIcon } from "./getCarrierIcon";

const Orders = () => {
  const [orders, setOrders] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const formattedDate = (value) => {
    return new Date(
      value.createdAt[0],
      value.createdAt[1] - 1,
      value.createdAt[2],
      value.createdAt[3],
      value.createdAt[4],
      value.createdAt[5]
    );
  };

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
          <div className="ship__section">
            <div className="ship__card__header">
              <h3 className="ship__page__heading">Orders</h3>
            </div>
            {orders && orders.length > 0 ? (
              <div className="card ship__card results__padding ">
                <Table size="md">
                  <Thead verticalAlign="middle">
                    <Tr>
                      <Th>Courier</Th>
                      <Th>Order</Th>

                      <Th>From</Th>
                      <Th>To</Th>
                    </Tr>
                  </Thead>
                  <Tbody>
                    {orders
                      .sort((a, b) => formattedDate(b) - formattedDate(a))
                      .map((order, index) => (
                        <Tr key={index} className="results__row">
                          <Td>
                            <Flex alignItems="center">
                              <div className="results__icon">
                                {getCarrierIcon(order.carrierName)}
                              </div>
                              <div>
                                {order.carrierName} - {order.carrierService}
                              </div>
                            </Flex>
                          </Td>
                          <Td>{order.orderNumber} </Td>

                          <Td>{order.shipFrom}</Td>
                          <Td>{order.shipTo}</Td>
                        </Tr>
                      ))}
                  </Tbody>
                </Table>
              </div>
            ) : (
              <div className="no__results"> No Results </div>
            )}
          </div>
        </div>
      )}
    </>
  );
};

export default Orders;
