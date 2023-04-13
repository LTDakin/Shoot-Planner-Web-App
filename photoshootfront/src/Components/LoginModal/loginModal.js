import {React, useState} from 'react'
import { useNavigate } from 'react-router-dom';
import './loginModal.css'
import AccountCreationModal from '../accountCreationModal/AccountCreationModal.js';

function LoginModal({closeloginmodal}){
    const [openACModal, setOpenACModal] = useState(false)

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    })

    let navigate = useNavigate();

    const handleInputChange = (event) => {
        const { name, value } = event.target
        setFormData({...formData, [name]: value})
    }

    function login() {
        // send a login request to api
        fetch("http://localhost:8080/api/photographer/login",{
            method: 'POST',
            headers: {
                'Content-Type' : 'application/json'
            },
            // TODO see if this works without filling other fields, if not then add blank for cam
            body : JSON.stringify({
                name: formData.username,
                password: formData.password
            })
        })
        .then(response => {
            if(response.ok)
                response.json()
            else
                console.log("error")
        })
        .then(data => {
            // store the cookie, move page to dashboard
            console.log(data)
            closeloginmodal(false)
            navigate("/dashboard")
        })
        .catch(error => {
            console.log(error)
            // display the incorrect credentials error message
        })
    }

    return(
        <div className="modalBackground">
            <div className="modalContainer">
                <div className="titleCloseBtn">
                    <button onClick={() => closeloginmodal(false)}> X </button>
                </div>
                <div className='title'>
                    <h1 id="LoginTitle">
                        Login
                    </h1>
                </div>
                <div className='body'>
                    <form className="form-body">
                        <input placeholder="Username" type="text" name="username" value={formData.username} onChange={handleInputChange}/>
                        <input placeholder="Password" type="password" name="password" value={formData.password} onChange={handleInputChange}/>
                    </form>
                </div>
                <div className='footer'>
                    <button id="cancelBtn" onClick={login}>Login</button>
                    <button id="createBtn" onClick={()=>setOpenACModal(true)}>I'm New</button>
                </div>
            </div>
            {openACModal && <AccountCreationModal closeacmodal={setOpenACModal}/>}
        </div>
    )
}

export default LoginModal