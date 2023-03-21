import React from 'react';
import Navbar from '../../Components/navbar/NavBar'
import './Home.css'

function Home() {
  return (
    <div id="background">
      <Navbar />
      <div className="hero-body">
        <h1 className="hero">Tamen</h1>
        <p className="tagline">The Photographer's assitant for planning shoots, storing photos, and client organization</p>
        <button>Create an account</button>
      </div>
    </div>
  );
}

export default Home;
