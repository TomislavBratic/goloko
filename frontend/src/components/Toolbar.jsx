const Toolbar = ({toggleDarkMode}) => {
    return (
        <header className="w-full p-2 max-h-12 flex justify-between items-center bg-[#E3A933] shadow-md">
            <div className="flex items-center">
                <img src="/centered_bird_logo.png" className="w-35 h-35 mt-6 hover:scale-110 transition:300"></img>
                 <img src="/goloko-logo-without-bg.png" className="w-35 h-35 hover:scale-110 transition:300"></img>
            </div>
            <nav className="space-x-4">
                <a href="#" className="text-gray-100 hover:text-gray-300 transition">Home</a>
                <a href="#" className="text-gray-100 hover:text-gray-300 transition">About</a>
                <a href="#" className="text-gray-100 hover:text-gray-300 transition">Contact</a>
                <button onClick={toggleDarkMode} className="ml-4 mr-1 px-2 py-1 border rounded text-sm text-gray-100
                 dark:text-gray-200 hover:bg-amber-700 dark:hover-gray-200 transition">Toggle Dark</button>
            </nav>
        </header>
    );
}

export default Toolbar;