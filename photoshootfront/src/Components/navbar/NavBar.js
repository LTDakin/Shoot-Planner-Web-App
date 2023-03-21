import React from 'react';
import { Link } from 'react-router-dom';
import './navbar.css';
import cameraIcon from '../../Images/camera-icon.png'

function Navbar() {
  return (
    <nav id="navbar">
      <ul>
        <li>
        <Link to="/">
        <img id="Icon" src={cameraIcon} alt="Camera Icon"></img>
      </Link>
        </li>
      <li>
      <button><Link className='navbarLink' to="/dashboard">Dash Board</Link></button>
      </li>
      <li id="profileLi">
      <div id="Profile">
        <button>Profile</button>
      </div>
      </li>
      </ul>
      
    </nav>
  );
}

export default Navbar;