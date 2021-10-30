import React from "react";
import "../../styles/Dashboard.css";
import { Flex, Table, Th, Tr, Thead, Tbody, Td } from "@chakra-ui/react";
import { getCarrierIcon } from "./getCarrierIcon";
import { Link } from "react-router-dom";

const DashboardViewOrders = ({ data }) => {
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

  return (
    <div className="card marg-top">
      <div className="view__orders__card">
        <h3>View Orders</h3>
      </div>
      {data && data.length > 0 ? (
        <>
          <Table size="sm">
            <Thead verticalAlign="middle">
              <Tr>
                <Th>Courier</Th>
                <Th>Order</Th>
                <Th>To</Th>
              </Tr>
            </Thead>
            <Tbody>
              {data
                .sort((a, b) => formattedDate(b) - formattedDate(a))
                .slice(0, 3)
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
                    <Td>{order.shipTo}</Td>
                  </Tr>
                ))}
            </Tbody>
          </Table>
          <Flex justifyContent="flex-end" padding="20px">
            <Link className="view__all__link" to="/dashboard/orders">
              View All
            </Link>
          </Flex>
        </>
      ) : (
        <div className="view__orders__main">
          <p>You currently have no orders placed</p>
        </div>
      )}
    </div>
  );
};

export default DashboardViewOrders;
