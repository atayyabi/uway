import React, { useState } from "react";
import "../../styles/Dashboard.css";
import { Formik, Form } from "formik";
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
import FormikControl from "../Formik/FormikControl";
import { fromCountries, toCountries, packageType } from "./listItems";
import { getQuote } from "../../api/Eshipper";
import { getCarrierIcon } from "./getCarrierIcon";
import { useHistory } from "react-router-dom";
import { useMediaQuery } from "@chakra-ui/react";

var jsonxml = require("jsontoxml");

const initialValues = {
  from: {
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
    address1: "",
    address2: "",
    country: "",
    zip: "",
    state: "",
    city: "",
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

const Quote = () => {
  const [isSmallerThanMedium] = useMediaQuery("(max-width: 980px)");
  const [isSmallerThanSmall] = useMediaQuery("(max-width: 500px)");
  const [quotes, setQuotes] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [selectedRate, setSelectedRate] = useState({});
  const [formData, setFormData] = useState({});
  const [activeIndex, setActiveIndex] = useState("");

  const history = useHistory();

  const handleSubmit = (values) => {
    const payload = {
      QuoteRequest: {
        From: {
          id: "1",
          company: "sender",
          address1: undefined,
          city: undefined,
          state: undefined,
          country: values.from.country,
          zip: values.from.zip,
        },
        To: {
          company: "receiver",
          address1: undefined,
          city: undefined,
          state: undefined,
          country: values.to.country,
          zip: values.to.zip,
        },
        Packages: {
          type: values.orderSummary.type,
          Package: {
            length:
              values.orderSummary.type === "package"
                ? values.orderSummary.length
                : "1",
            width:
              values.orderSummary.type === "package"
                ? values.orderSummary.width
                : "1",
            height:
              values.orderSummary.type === "package"
                ? values.orderSummary.height
                : "1",
            weight:
              values.orderSummary.type === "package"
                ? values.orderSummary.weight
                : "1",
          },
        },
      },
    };
    const data = jsonxml(payload);
    console.log(data);
    setIsLoading(true);
    getQuote(data)
      .then((res) => setQuotes(res.quoteReply.quote))
      .then(() => setFormData(values))
      .then(() => setIsLoading(false));
  };

  const handleRateSelect = (quote, index) => {
    setSelectedRate(quote);
    setActiveIndex(index);
  };

  const pushToShipPage = () => {
    const quoteRate = selectedRate;
    history.push("/dashboard/ship", {
      state: formData,
      quoteRate,
      activeIndex,
    });
  };
  return (
    <div className="dashboard__section__wrapper">
      <div className="ship__section">
        <div className="ship__card__header">
          <h3 className="ship__page__heading">
            Get a <span>quote</span>
          </h3>
        </div>

        <div className="card ship__card quote__padding">
          <Formik
            initialValues={initialValues}
            onSubmit={(values) => handleSubmit(values)}
          >
            {(formik) => {
              return (
                <Form>
                  <Flex flexDirection="column">
                    <div className="">
                      <p>Ship From</p>
                    </div>
                    <Flex
                      margin="10px 0"
                      flexDirection={isSmallerThanSmall ? "column" : "row"}
                    >
                      <div className="country__input">
                        <FormikControl
                          control="select"
                          // variant="filled"
                          label="Country"
                          name="from.country"
                          placeholder="Select Country"
                          options={fromCountries}
                          disabled
                        />
                      </div>
                      <div
                        className={
                          isSmallerThanSmall
                            ? "country__input"
                            : "postal__input"
                        }
                      >
                        <FormikControl
                          control="input"
                          label="Postal Code"
                          name="from.zip"
                        />
                      </div>
                    </Flex>
                  </Flex>
                  <Flex flexDirection="column" margin="15px 0 25px 0">
                    <div className="">
                      <p>Ship To</p>
                    </div>
                    <Flex
                      margin="10px 0"
                      flexDirection={isSmallerThanSmall ? "column" : "row"}
                    >
                      <div className="country__input">
                        <FormikControl
                          control="select"
                          label="Country"
                          options={toCountries}
                          name="to.country"
                          placeholder="Select Country"
                        />
                      </div>
                      <div
                        className={
                          isSmallerThanSmall
                            ? "country__input"
                            : "postal__input"
                        }
                      >
                        <FormikControl
                          control="input"
                          label="Postal Code"
                          name="to.zip"
                        />
                      </div>
                    </Flex>
                  </Flex>
                  <hr />
                  <Flex flexDirection="column" margin="25px 0 10px 0">
                    <div className="">
                      <p>Order Summary</p>
                    </div>
                    <Flex
                      margin="10px 0"
                      flexDirection={isSmallerThanMedium ? "column" : "row"}
                    >
                      <div className="country__input">
                        <FormikControl
                          control="select"
                          label="Item Type"
                          options={packageType}
                          name={"orderSummary.type"}
                        />
                      </div>
                      {formik.values.orderSummary.type === "package" && (
                        <>
                          <Flex flexDirection="column" margin="0 20px 0 0">
                            <label className="dimensions__label">
                              Dimensions (inches)
                            </label>
                            <Flex>
                              <div className="dimensions__input">
                                <FormikControl
                                  control="input"
                                  name="orderSummary.length"
                                />
                              </div>
                              <div className="dimensions__separator">x</div>
                              <div className="dimensions__input">
                                <FormikControl
                                  control="input"
                                  name="orderSummary.width"
                                />
                              </div>
                              <div className="dimensions__separator">x</div>
                              <div className="dimensions__input">
                                <FormikControl
                                  control="input"
                                  name="orderSummary.height"
                                />
                              </div>
                            </Flex>
                          </Flex>
                          <div className="postal__input">
                            <FormikControl
                              control="input"
                              label="Weight (lbs)"
                              name="orderSummary.weight"
                            />
                          </div>
                        </>
                      )}
                    </Flex>
                  </Flex>
                  <Flex>
                    <div className="switch__input">
                      <FormikControl
                        control="switch"
                        label="Residential Address?"
                        name="to.isResidential"
                      />
                    </div>
                  </Flex>
                  <Flex justifyContent="flex-end">
                    <button
                      disabled={isLoading}
                      type="submit"
                      className="quote__btn"
                    >
                      {isLoading ? (
                        <CircularProgress
                          isIndeterminate
                          size={15}
                          style={{ padding: "0px 33px" }}
                        />
                      ) : (
                        "Get a quote"
                      )}
                    </button>
                  </Flex>
                </Form>
              );
            }}
          </Formik>
        </div>

        {quotes && quotes.length > 0 && (
          <div className="ship__marg">
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
                      <Td margin="0 0px 0 0">
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
              {selectedRate?.serviceId && (
                <div className="quote__btn__container ship__step__padding">
                  <button className="quote__btn " onClick={pushToShipPage}>
                    Continue
                  </button>
                </div>
              )}
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default Quote;
