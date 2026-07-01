import Gmap from "./Gmap";
import Toolbar from "./Toolbar"

const HomePage = ({toggleDarkMode}) => {
    return (
        <div class="w-full 100vh">
            <Toolbar toggleDarkMode={toggleDarkMode}/>
                <Gmap></Gmap>
        </div>
    );
};

export default HomePage;