import React from "react";
import {
  FEATURES_CAL,
  FEATURES_LAYERS,
  FEATURES_NOTIF,
} from "../../assets/icons";

const features = [
  {
    title: "Browse through our carriers",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac interdum ante. Vestibulum hendrerit dolor eget fermentum dapibus. Sed blandit.",
    icon: FEATURES_LAYERS,
  },
  {
    title: "Manage and book shipments ",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac interdum ante. Vestibulum hendrerit dolor eget fermentum dapibus. Sed blandit.",
    icon: FEATURES_CAL,
  },
  {
    title: "Follow and get notified",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac interdum ante. Vestibulum hendrerit dolor eget fermentum dapibus. Sed blandit.",
    icon: FEATURES_NOTIF,
  },
];

const Features = () => {
  return (
    <div className="features">
      {features.map((feature, index) => (
        <div className="feature" key={index}>
          <span className="feature__icon__container">
            <div>{feature.icon}</div>
          </span>
          <h5>{feature.title}</h5>
          <p>{feature.description}</p>
        </div>
      ))}
    </div>
  );
};

export default Features;
