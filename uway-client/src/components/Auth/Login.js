import React, {useContext} from "react";
import "../../styles/Auth.css";
import { Formik, Form } from "formik";
import FormikControl from "../Formik/FormikControl";
import { Flex } from "@chakra-ui/react";
import { Link } from "react-router-dom";
import {signin} from "../../api/Auth";
import {useHistory} from "react-router-dom";
import {Auth} from "../../context/AuthProvider";
import {LOGIN} from "../../constants/Auth";

const initialValues = {
  username: "",
  password: "",
};

const Login = () => {

  const history = useHistory();

  const {dispatch} = useContext(Auth);

  const handleSubmit = (values) => {
    const formData = {
      username: values.username,
      password: values.password
    }
    signin(formData)
    .then((res) => {
      console.log(res)
      dispatch({
        type: LOGIN,
        payload: res
      })
    })
    .then(() => {
      history.push("/dashboard/home")
    })
  }

  return (
    <div className="auth__page">
      <div className="auth__form__container">
        <div className="auth__header">
          <h2>Sign in to Uway</h2>
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
                    name="username"
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
                  <button className="auth__btn" type="submit">Sign In</button>
                </Flex>
              </Flex>
            </Form>
          </Formik>
        </div>
        <div className="auth__footer">
          <Link to="/signup">Don't have an account?</Link>
        </div>
      </div>
    </div>
  );
};

export default Login;
