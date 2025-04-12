import Toolbar from "./Toolbar"

const HomePage = ({toggleDarkMode}) => {
    return (
        <div>
            <Toolbar toggleDarkMode={toggleDarkMode}/>
            <main className="p-8">
                <h2 className="text-3xl font-bold mb-4 text-gray-400"> Welcome to Goloko</h2>
                <p className="text-gray-700 dark:text-gray-300">Here you can add your events</p>
            </main>
        </div>
    );
};

export default HomePage;