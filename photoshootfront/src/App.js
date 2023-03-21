import './App.css';
import React from 'react';
import { Routes, Route } from 'react-router-dom';

import Home from './Pages//Home/Home';
import DashBoard from './Pages/DashBoard/DashBoard';

function App() {
  return (
    <div>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/dashboard" element={<DashBoard />} />
      </Routes>
    </div>
  );
}

export default App;
