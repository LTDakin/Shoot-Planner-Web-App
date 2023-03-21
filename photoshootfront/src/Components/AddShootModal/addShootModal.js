import React from 'react'
import './addShootModal.css'

function addShootModal({closeShootModal}){

    function requestAddShootSession () {
        console.log("requesting api to add shoot session to database")
        
    }

    return(
        <div className="modalBackground">
            <div className="modalContainer">
                <div className="titleCloseBtn">
                    <button onClick={() => closeShootModal(false)}> X </button>
                </div>
                <div className='title'>
                    <h1>
                        Shoot Session Details
                    </h1>
                </div>
                <div className='body'>
                    <form className="form-body">
                        <input type="text" name="client"/>
                        <input type="date" name="date"/>
                        <input type="text" name="location"/>
                        <input type="number" name="length"/>
                    </form>
                </div>
                <div className='footer'>
                    <button id="cancelBtn" onClick={() => closeShootModal(false)}>Cancel</button>
                    <button id="createBtn" onClick={requestAddShootSession}>Create</button>
                </div>
            </div>
        </div>
    )
}

export default addShootModal