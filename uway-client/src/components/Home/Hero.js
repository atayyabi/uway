import React from "react";
import "../../styles/Home.css";
import {HERO_IMG} from "../../assets/images"

const Hero = () => {
  return (
    <div className="hero__wrapper">
      <section className="hero__section">
        <div className="hero__content">
          <div className="hero__heading">
            <div className="hero__heading__content">
              <h1>The ultimate <span>shipping</span> platform has arrived.</h1>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
                eu ultricies tortor. Vestibulum pulvinar, sem id sodales
                tristique, turpis est faucibus ligula, eget posuere enim ipsum
                id felis. Suspendisse dictum velit nulla, ut rhoncus odio
                consequat in. Ut sed hendrerit massa. 
              </p>
              <button className="hero__btn">Get Started</button>
            </div>
          </div>
          <div className="hero__img__section">
            <div className="hero__img__content">
              <div className="hero__img">
                <div className="hero">
                  {HERO_IMG}
                </div>

                
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default Hero;
