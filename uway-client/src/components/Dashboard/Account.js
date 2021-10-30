import React, { useContext } from "react";
import "../../styles/Dashboard.css";
import { Auth } from "../../context/AuthProvider";
import { Flex, Table, Tbody, Td, Tr, Thead } from "@chakra-ui/react";

const Account = () => {
  const { state: authState } = useContext(Auth);

  return (
    <div className="dashboard__section__wrapper">
      <div className="ship__section account">
        <div className="ship__card__header">
          <h3 className="ship__page__heading">Account</h3>
        </div>
        <div className="card ship__card results__padding ">
          <Flex padding="20px 0 0 20px">
            <Flex alignItems="flex-end" margin="0 0 0px 0px">
              <span className="account__user">{authState.user.fullName}</span>
            </Flex>
          </Flex>
          <Table size="md">
            <Thead>
              <Tr>
                <Td></Td>
                <Td></Td>
              </Tr>
            </Thead>
            <Tbody>
            <Tr className="results__row">
                <Td>
                  <span className="account__category">Name:</span>
                </Td>
                <Td isNumeric>
                  <span>{authState.user.fullName}</span>
                </Td>
              </Tr>
              <Tr className="results__row">
                <Td>
                  <span className="account__category">Email Address:</span>
                </Td>
                <Td isNumeric>
                  <span>{authState.user.email}</span>
                </Td>
              </Tr>
              <Tr className="results__row">
                <Td>
                  <span className="account__category">Password:</span>
                </Td>
                <Td isNumeric>
                  <span type="password">{"•••••••••••••••"}</span>
                </Td>
              </Tr>
            </Tbody>
          </Table>
        </div>
      </div>
    </div>
  );
};

export default Account;
