import {MdDashboard} from "react-icons/md";
import {FaBoxOpen, FaUserCog} from "react-icons/fa";
import {BsFillCalculatorFill} from "react-icons/bs";
import {IoIosListBox} from "react-icons/io"

export const dashboardRoutes = [
  {
    name: "Dashboard",
    path: "/home",
    icon: <MdDashboard />,
  },
  {
    name: "Quote",
    path: "/quote",
    icon: <BsFillCalculatorFill />,
  },
  {
    name: "Ship",
    path: "/ship",
    icon: <FaBoxOpen />,
  },
  {
    name: "Orders",
    path: "/orders",
    icon: <IoIosListBox />, 
  },
  {
    name: "Account",
    path: "/account",
    icon: <FaUserCog />,
  },
];
