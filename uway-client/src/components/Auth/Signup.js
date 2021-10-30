import React, { useContext } from "react";
import "../../styles/Auth.css";
import { Formik, Form } from "formik";
import FormikControl from "../Formik/FormikControl";
import { Flex } from "@chakra-ui/react";
import { Link } from "react-router-dom";
import { signup, signin } from "../../api/Auth";
import { useHistory } from "react-router-dom";
import { Auth } from "../../context/AuthProvider";
import { LOGIN } from "../../constants/Auth";

const initialValues = {
  fullName: "",
  email: "",
  password: "",
};

const Signup = () => {
  const history = useHistory();
  const { dispatch } = useContext(Auth);

  const handleSubmit = (values) => {
    const formData = {
      fullName: values.fullName,
      username: values.email,
      password: values.password,
    };
    signup(formData).then((res) => {
      console.log(res)
      signin({ username: values.email, password: values.password })
      .then( (res) => {
          console.log(res);
          dispatch({
            type: LOGIN,
            payload: res
          })
        }
      )
      .then(() => {
        history.push("/dashboard/home");
      });
    });
  };
  return (
    <div className="auth__page">
      <div className="auth__form__container">
        <div className="auth__header">
          <h2>Sign up with Uway</h2>
        </div>
        <div className="card auth__card">
          <Formik
            initialValues={initialValues}
            onSubmit={(values) => handleSubmit(values)}
          >
            <Form>
              <Flex flexDirection="column" padding="20px">
                <div className="auth__input">
                  <FormikControl
                    control="input"
                    name="fullName"
                    label="Full Name"
                  />
                </div>
                <div className="auth__input">
                  <FormikControl
                    control="input"
                    name="email"
                    label="Email Address"
                  />
                </div>
                <div className="auth__input">
                  <FormikControl
                    control="input"
                    name="password"
                    label="Password"
                    type="password"
                  />
                </div>

                <Flex justifyContent="flex-end">
                  <button className="auth__btn" type="submit">
                    Sign Up
                  </button>
                </Flex>
              </Flex>
            </Form>
          </Formik>
        </div>
        <div className="auth__footer">
          <Link to="/login">Already have an account?</Link>
        </div>
      </div>
    </div>
  );
};

export default Signup;
