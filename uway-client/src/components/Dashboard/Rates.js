import React, {useEffect} from "react";
import { Flex, Table, Th, Tr, Thead, Tbody, Td } from "@chakra-ui/react";
import { getCarrierIcon } from "./getCarrierIcon";

const Rates = ({
  quotes,
  selectedRate,
  setSelectedRate,
  step,
  setStep,
  activeIndex,
  setActiveIndex,
}) => {
  const handleRateSelect = (quote, index) => {
    setSelectedRate(quote);
    setActiveIndex(index);
  };

  useEffect(() => {
    window.scrollTo(0,0);
  }, [])


  return (
    <>
      <div className="ship__card__header">
        <h3>Select Rate (Step 2 of 3)</h3>
      </div>
      {quotes && quotes.length > 0 && (
        <div>
          <div className="card ship__card results__padding">
            <Table size="md">
              <Thead verticalAlign="middle">
                <Tr>
                  <Th>Courier</Th>
                  <Th>Transit Days</Th>
                  <Th>Estimated Delivery</Th>
                  <Th>Total Cost</Th>
                </Tr>
              </Thead>
              <Tbody>
                {quotes.map((quote, index) => (
                  <Tr
                    key={index}
                    className="results__row"
                    onClick={() => handleRateSelect(quote, index)}
                    style={
                      index === activeIndex
                        ? { backgroundColor: "rgba(29, 144, 245, 0.07)" }
                        : null
                    }
                  >
                    <Td>
                      <Flex alignItems="center">
                        <div className="results__icon">
                          {getCarrierIcon(quote.carrierName)}
                        </div>
                        <div>
                          {quote.carrierName} - {quote.serviceName}
                        </div>
                      </Flex>
                    </Td>

                    <Td>{quote.transitDays} day(s)</Td>
                    <Td>{quote.deliveryDate}</Td>
                    <Td>
                      {
                        <>
                          {quote.totalCharge} {quote.currency}{" "}
                        </>
                      }
                    </Td>
                  </Tr>
                ))}
              </Tbody>
            </Table>
            <div className="quote__btn__container ship__step__padding">
              <button className="back__btn" onClick={() => setStep(step - 1)}>
                Back
              </button>
              {selectedRate?.serviceId && (
                <button
                  className="quote__btn"
                  onClick={() => setStep(step + 1)}
                >
                  Continue
                </button>
              )}
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Rates;
