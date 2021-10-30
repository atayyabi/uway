import React, { useEffect } from "react";
import "../../styles/Dashboard.css";
import { Flex, CircularProgress } from "@chakra-ui/react";
import FormikControl from "../Formik/FormikControl";
import {
  fromCountries,
  toCountries,
  packageType,
  provinces,
  states,
} from "./listItems";
import { useMediaQuery } from "@chakra-ui/react";

const ShipForm = ({ step, setStep, formik, isLoading }) => {
  const [isSmallerThanMedium] = useMediaQuery("(max-width: 980px)");
  const [isSmallerThanSmall] = useMediaQuery("(max-width: 500px)");

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  return (
    <>
      <div className="ship__card__header">
        <h3>Shipment Information (Step 1 of 3)</h3>
      </div>
      <div className="card ship__card ship__padding">
        <Flex flexDirection="column">
          <div className="">
            <h5>Ship From</h5>
          </div>

          <Flex margin="10px 0" flexDirection={isSmallerThanSmall ? "column" : "row"}>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Sender Name"
                  name="from.company"
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Contact No."
                  name="from.phone"
                />
              </div>
            </Flex>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Email Address"
                  name="from.email"
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Address"
                  name="from.address1"
                />
              </div>
            </Flex>
          </Flex>
        </Flex>
        <Flex flexDirection="column">
        <Flex margin="10px 0" flexDirection={isSmallerThanSmall ? "column" : "row"}>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="select"
                  label="Country"
                  options={fromCountries}
                  name="from.country"
                  placeholder="Select Country"
                  disabled
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Postal"
                  name="from.zip"
                />
              </div>
            </Flex>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl control="input" label="City" name="from.city" />
              </div>
              <div className="country__input">
                <FormikControl
                  control="select"
                  label="Province"
                  name="from.state"
                  options={provinces}
                  placeholder="Select Province"
                />
              </div>
            </Flex>
          </Flex>
        </Flex>
      </div>

      <div className="card ship__card ship__marg ship__padding">
        <Flex flexDirection="column">
          <div className="">
            <h5>Ship To</h5>
          </div>
          <Flex margin="10px 0" flexDirection={isSmallerThanSmall ? "column" : "row"}>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Receiver Name"
                  name="to.company"
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Contact No."
                  name="to.phone"
                  placeholder="Optional"
                />
              </div>
            </Flex>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Email Address"
                  name="to.email"
                  placeholder="Optional"
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Address Line 1"
                  name="to.address1"
                />
              </div>
            </Flex>
          </Flex>
        </Flex>
        <Flex flexDirection="column">
        <Flex margin="10px 0" flexDirection={isSmallerThanSmall ? "column" : "row"}>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
              <div className="country__input">
                <FormikControl
                  control="select"
                  label="Country"
                  options={toCountries}
                  name="to.country"
                  placeholder="Select Country"
                />
              </div>
              <div className="country__input">
                <FormikControl
                  control="input"
                  label="Zip / Postal"
                  name="to.zip"
                />
              </div>
            </Flex>
            <Flex flexDirection={isSmallerThanMedium ? "column" : "row"}>
            <div className="country__input">
              <FormikControl control="input" label="City" name="to.city" />
            </div>
            <div className="country__input">
              <FormikControl
                control="select"
                label="State / Province"
                name="to.state"
                options={formik.values.to.country === "CA" ? provinces : states}
                placeholder={"Select State / Province"}
              />
            </div>
            </Flex>
          </Flex>
        </Flex>
        <Flex margin="10px 0 0 0">
          <div className="switch__input">
            <FormikControl
              control="switch"
              label="Residential Address?"
              name="to.isResidential"
            />
          </div>
        </Flex>
      </div>

      <div className="card ship__card ship__marg ship__padding">
        <Flex flexDirection="column" margin="0px 0 10px 0">
          <div className="">
            <h5>Order Summary</h5>
          </div>
          <Flex margin="10px 0" flexDirection={isSmallerThanMedium ? "column" : "row"}>
            <div className="country__input">
              <FormikControl
                control="select"
                label="Item Type"
                options={packageType}
                name="orderSummary.type"
              />
            </div>

            <Flex flexDirection="column" margin="0 20px 0 0">
              <label className="dimensions__label">Dimensions (inches)</label>
              <Flex>
                <div className="dimensions__input">
                  <FormikControl control="input" name="orderSummary.length" />
                </div>
                <div className="dimensions__separator">x</div>
                <div className="dimensions__input">
                  <FormikControl control="input" name="orderSummary.width" />
                </div>
                <div className="dimensions__separator">x</div>
                <div className="dimensions__input">
                  <FormikControl control="input" name="orderSummary.height" />
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
          </Flex>
        </Flex>
        <Flex justifyContent="flex-end">
          <button disabled={isLoading} type="submit" className="quote__btn">
            {isLoading ? (
              <CircularProgress
                isIndeterminate
                size={15}
                style={{ padding: "0px 23px" }}
              />
            ) : (
              "Continue"
            )}
          </button>
        </Flex>
      </div>
    </>
  );
};

export default ShipForm;
