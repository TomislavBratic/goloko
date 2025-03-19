import './App.css'
import HomePage from "./assets/components/HomePage"
import { useState } from 'react'

function App() {
  const [isDark, setIsDark] = useState(false);

  const toggleDarkMode = () => {
    document.documentElement.classList.toggle("dark");
    setIsDark(!isDark);
  }
  return (
    <div className='bg-white min-h-screen'>
      <HomePage toggleDarkMode={toggleDarkMode} />
    </div>
  );
}

export default App
