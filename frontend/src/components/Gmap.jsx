import {APIProvider, Map} from '@vis.gl/react-google-maps';

const Gmap = () => {
    return (
    <APIProvider apiKey={import.meta.env.VITE_GOOGLE_MAPS_API_KEY}>
        <Map
        style={{width: '100vw', height: '94vh'}}
        defaultCenter={{lat: 45.8150, lng: 15.9819}}
        defaultZoom={13}
        gestureHandling='greedy'
        disableDefaultUI
                />
    </APIProvider>
    );
};

export default Gmap;