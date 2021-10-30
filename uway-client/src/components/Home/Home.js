import React from 'react'
import Hero from "./Hero";
import "../../styles/Home.css"
import Features from "./Features";

const Home = () => {
    return (
        <div className="home__page">
            <Hero />
            <Features />
           
        </div>
    )
}

export default Home
