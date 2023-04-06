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
        .then(response => response.json())
        //if success then close the accountcreationmodal, store the cookie?, and go back to login
        // this is running regardless of wheter the username exists or not because technically there is no error, need to find a way to check the response header and then react accordingly
        .then(data => {
            console.log(data)
            closeacmodal(false)
        })
        //if username taken or error then don't close and give a popup to let the user know something went wrong
        .catch(error => {
            alert("Username Already Exists")
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