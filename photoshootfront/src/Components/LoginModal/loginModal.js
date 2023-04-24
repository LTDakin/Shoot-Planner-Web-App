import { React, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getCookie } from "../../Utils";
import "./loginModal.css";
import AccountCreationModal from "../accountCreationModal/AccountCreationModal.js";

function LoginModal({ closeloginmodal }) {
  const [openACModal, setOpenACModal] = useState(false);

  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  let navigate = useNavigate();

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  function login() {
    // send a login request to api
    fetch("http://localhost:8080/api/photographer/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: formData.username,
        password: formData.password,
      }),
    }).then((response) => {
      // check the cookies
      console.log("checking for username cookie: " + getCookie("username"));
      // on succesful login close login modal and reroute to the dashboard
      if (response.ok) {
        response.json().then((data) => {
          console.log(data);
          closeloginmodal(false);
          navigate("/dashboard");
        });
      } else {
        // unsuccesful login should stay on the login modal and display the error text
        console.log("response error");
        console.log(response.json());
        // TODO display error text
      }
    });
  }

  return (
    <div className="modalBackground">
      <div className="modalContainer">
        <div className="titleCloseBtn">
          <button onClick={() => closeloginmodal(false)}> X </button>
        </div>
        <div className="title">
          <h1 id="LoginTitle">Login</h1>
        </div>
        <div className="body">
          <form className="form-body">
            <input
              placeholder="Username"
              type="text"
              name="username"
              value={formData.username}
              onChange={handleInputChange}
            />
            <input
              placeholder="Password"
              type="password"
              name="password"
              value={formData.password}
              onChange={handleInputChange}
            />
          </form>
        </div>
        <div className="footer">
          <button id="cancelBtn" onClick={login}>
            Login
          </button>
          <button id="createBtn" onClick={() => setOpenACModal(true)}>
            I'm New
          </button>
        </div>
      </div>
      {openACModal && <AccountCreationModal closeacmodal={setOpenACModal} />}
    </div>
  );
}

export default LoginModal;
