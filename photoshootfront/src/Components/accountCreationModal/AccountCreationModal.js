import {React, useState } from 'react'
import './accountCreationModal.css'

function AccountCreationModal({closeacmodal}){
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        email:'',
        camera:'',
    })

    const handleInputChange = (event) => {
        const { name, value } = event.target
        setFormData({...formData, [name]: value})
    }

    function createAccount() {
        //send data to the api
        fetch("http://localhost:8080/api/photographer", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: formData.username,
                camera: formData.camera,
                email: formData.email,
                password: formData.password
            })
        })
        // check for bad request
        .then(response => {
            if(response.ok)
                response.json()
            else
                throw new Error("Username already taken")

        })
        // if success then close the accountcreationmodal, store the cookie?, and go back to login, should be skipped if response not ok
        .then(data => {
            // TODO remove this for security
            console.log(data)
            closeacmodal(false)
        })
        // catches bad request error makes username error message visible
        .catch(error => {
            document.getElementById("username_error_msg").style.visibility = "visible"
            console.log(error)
        })
    }

    return(
        <div className="modalBackground">
            <div className="modalContainer">
                <div className="titleCloseBtn">
                    <button onClick={() => closeacmodal(false)}> X </button>
                </div>
                <div className='title'>
                    <h1 id="NewAccountTitle">
                        New Account
                    </h1>
                </div>
                <div className='body'>
                    <form className="form-body">
                        <p id="username_error_msg">Username is already taken</p>
                        <input placeholder="Username" type="text" name="username" value={formData.username} onChange={handleInputChange}/>
                        <input placeholder="Password" type="password" name="password" value={formData.password} onChange={handleInputChange}/>
                        <input placeholder="Email" type="email" name="email" value={formData.email} onChange={handleInputChange}/>
                        <input placeholder="Camera" type="text" name="camera" value={formData.camera} onChange={handleInputChange}/>
                    </form>
                </div>
                <div className='footer'>
                    <button id="createBtn" onClick={createAccount}>Create Account</button>
                </div>
            </div>
        </div>
    )
}

export default AccountCreationModal