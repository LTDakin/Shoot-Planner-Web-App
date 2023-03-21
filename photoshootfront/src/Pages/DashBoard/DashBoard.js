import {useState, useEffect} from 'react'
import Navbar from '../../Components/navbar/NavBar'
import AddShootModal from '../../Components/AddShootModal/addShootModal'
import './DashBoard.css'

function DashBoard() {
  const [openShootModal, setOpenShootModal] = useState(false);
  const [sessions, setSessions] = useState([]);

  // This Function calls a GET to /api/shootsession to populate all shoot sessions into the dashboard
  // TODO call with a photographer id after login implemented to only get shoot sessions that are owned by that photographer
  

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/shootsession");
        const data = await response.json();
        setSessions(data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="page">
      < Navbar />
      <div className="dashboard-body">
      {sessions.map((session) => (
        <div className="dashboard-item" key={session.id}>
          <p>{session.location}</p>
          <p>{session.sessionDate}</p>
          <p>Photographer: {session.photographerId}</p>
          <p>Client: {session.clientId}</p>
          <p>{session.hourLength} Hours</p>
        </div>
      ))}
        <button className="dashboard-item" id="addNewShootBtn" onClick={()=>setOpenShootModal(true)}>+</button>
      </div>
      {openShootModal && <AddShootModal closeShootModal={setOpenShootModal}/>}
    </div>
  );
}

export default DashBoard;