import React from 'react'
import './loginModal.css'

function loginModal({closeloginmodal}){

    function createAccount () {
        console.log("requesting api for account creation")
    }

    function login () {
        console.log("requesting api for login")
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
                        <input label="Username" type="text" name="username"/>
                        <input label="Password" type="password" name="password"/>
                    </form>
                </div>
                <div className='footer'>
                    <button id="cancelBtn" onClick={login}>Login</button>
                    <button id="createBtn" onClick={createAccount}>Create Account</button>
                </div>
            </div>
        </div>
    )
}

export default loginModal