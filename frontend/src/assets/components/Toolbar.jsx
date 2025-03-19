const Toolbar = ({toggleDarkMode}) => {
    return (
        <header className="w-full p-2 max-h-12 flex justify-between items-center bg-amber-600 shadow-md">
            <div className="flex items-center">
            <img src="../../logo.svg" className="w-15 h-15 mr-2 hover:scale-110 transition:300"></img>
                <h1 className="text-xl font-bold text-gray-200 dark:text-gray-200"> Goloko</h1>
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