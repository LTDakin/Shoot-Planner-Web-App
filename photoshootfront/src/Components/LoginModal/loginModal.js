import {React, useState} from 'react'
import './loginModal.css'
import AccountCreationModal from '../accountCreationModal/AccountCreationModal';

function LoginModal({closeloginmodal}){
    const [openACModal, setOpenACModal] = useState(false);

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
                        <input placeholder="Username" label="Username" type="text" name="username"/>
                        <input placeholder="Password" label="Password" type="password" name="password"/>
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