import {Switch, BrowserRouter as Router } from "react-router-dom";
import Dashboard from "./components/Dashboard/Dashboard";
import Home from "./components/Home/Home";
import "./styles/App.css";
import Login from "./components/Auth/Login";
import Signup from "./components/Auth/Signup";
import RouteWithNav from "./components/Routes/RouteWithNav";
import { ChakraProvider } from "@chakra-ui/react"
import AuthProvider from "./context/AuthProvider";
import AuthenticatedRoute from "./components/Routes/AuthenticatedRoute"

const App = () => {
  return (
    <AuthProvider>
    <ChakraProvider>
    <Router>
      <Switch>
        <RouteWithNav path="/" exact component={Home} />
        <AuthenticatedRoute path="/dashboard" component={Dashboard} />
        <RouteWithNav path="/login" exact component={Login} />
        <RouteWithNav path="/signup" exact component={Signup} />
      </Switch>
    </Router>
    </ChakraProvider>
    </AuthProvider>
  );
};

export default App;
