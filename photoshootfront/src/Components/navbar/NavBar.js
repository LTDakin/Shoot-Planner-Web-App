import { React, useState, useEffect } from "react";
import { getCookie } from "../../Utils";
import { Link } from "react-router-dom";
import "./navbar.css";
import LoginModal from "../LoginModal/LoginModal";
import cameraIcon from "../../Images/camera-icon.png";
import profileTmp from "../../Images/profileTmp.png";

function Navbar() {
  const [openLoginModal, setOpenLoginModal] = useState(false);
  const [username, setUsername] = useState("");

  useEffect(() => {
    var username = "";
    console.log("current cookies in browser: " + document.cookie);
    username = getCookie("username");
    setUsername(username);
  }, []);

  return (
    <nav id="navbar">
      <ul>
        <li>
          <Link to="/">
            <img id="Icon" src={cameraIcon} alt="Camera Icon"></img>
          </Link>
        </li>
        <li>
          <button>
            <Link className="navbarLink" to="/dashboard">
              Dash Board
            </Link>
          </button>
        </li>
        <li id="profileLi">
          <div id="Profile">
            <img
              src={profileTmp}
              alt="profileTmp"
              onClick={() => setOpenLoginModal(true)}
            ></img>
          </div>
        </li>
        <li id="usernameLi">
          <p id="username">{username}</p>
        </li>
      </ul>
      {openLoginModal && <LoginModal closeloginmodal={setOpenLoginModal} />}
    </nav>
  );
}

export default Navbar;
