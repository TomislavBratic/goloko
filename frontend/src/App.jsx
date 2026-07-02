import ProtectedRoute from './api/ProtectedRoute';
import './App.css';
import HomePage from "./components/HomePage";
import Login from "./components/Login";
import Register from "./components/Register";
import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  const [isDark, setIsDark] = useState(false);

  const toggleDarkMode = () => {
    document.documentElement.classList.toggle("dark");
    setIsDark(!isDark);
  };

  return (
      <div
      >
        <Routes>
          <Route path='/' element={<ProtectedRoute><HomePage /></ProtectedRoute>} />
          <Route path='/login' element={<Login />} />
           <Route path='/register' element={<Register />} />
        </Routes>
      </div>
  );
}

export default App;
