import './App.css'
import HomePage from "./assets/components/HomePage"
import Login from "./assets/components/Login"
import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  const [isDark, setIsDark] = useState(false);

  const toggleDarkMode = () => {
    document.documentElement.classList.toggle("dark");
    setIsDark(!isDark);
  }
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/login' element={<Login />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App
