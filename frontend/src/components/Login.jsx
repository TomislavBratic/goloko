import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faGoogle, faFacebook, faGithub, faTwitter } from '@fortawesome/free-brands-svg-icons';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';

const Login = () => {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();
  const { login } = useAuth();

  const handleLogin = async () => { 
    try {
      setError("");

      const response =  await api.post("/api/auth/login", {
        email,
        password
      });

      login(response.data);
      navigate("/");
    }
    catch (err) { 
      setError("Invalid email or password");
      console.error(err);
    }

  }

  return (
     <div className="flex items-center justify-center min-h-screen  bg-[url('/background_pin.jpg')] bg-cover bg-center bg-no-repeat">
       <div className="w-full max-w-7xl bg-white shadow-lg flex rounded-xl overflow-hidden">
        <div className="w-1/2 hidden md:block">
        <img
          src="/login_image_new_with_cloud.jpg"
          alt="Login visual"
          className="w-full h-full object-cover"
            />
          </div>
          <div className="w-full md:w-1/2 flex flex-col justify-center p-8">
            
            <div className='flex justify-center items-center'>
            <img src="/login_sign_without_bg.png" className="w-48 h-48 hover:scale:110 transition:300"></img>
            </div>

            <input
              type="email"
              className=" p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 focus:ring-blue-400"
              placeholder="Username or Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            ></input>
            <input
              type="password"
              className="p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 focus:ring-blue-400"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}/>
              

            <div className="flex justify-center">
            <button
              onClick={handleLogin}
              className="w-1/5 p-3 mb-4 rounded bg-blue-950 text-white py-3 hover:bg-green-800 transition">Login</button>
              <label className="flex items-center ml-4  mb-4 gap-2 text-gray-500">
                 Remember me
                <input className="ml-1 mt-1 scale-125" type="checkbox"/>
              </label>
            </div>
            <div className="flex justify-center text-blue-500 hover:underline">
              <a href="#" className="">Forgot password?</a>
            </div>
           <div className="relative my-6 h-6">
              <div className="absolute inset-0 flex items-center">
                <div className="w-full border-t border-gray-300"></div>
              </div>

              <div className="relative flex justify-center">
                <span className="bg-white text-sm text-gray-500 px-2">or</span>
              </div>
            </div>
            <div className="flex flex-col justify-center items-center space-y-2">
              <button className='w-3/5 flex items-center justify-center bg-blue-800 hover:bg-blue-900 rounded text-white p-2 gap-2'>
                 <FontAwesomeIcon icon={faFacebook}/> Login with Facebook
              </button  >
                  <button className='w-3/5 flex items-center justify-center bg-sky-500 hover:bg-sky-600 rounded text-white p-2 gap-2'>
                 <FontAwesomeIcon icon={faTwitter}/> Login with Twitter
              </button>
                  <button className='w-3/5 flex items-center justify-center bg-red-600 hover:bg-red-700 rounded text-white p-2 gap-2'>
                 <FontAwesomeIcon icon={faGoogle}/> Login with Google
              </button>
            </div>
            <div className='flex justify-center mt-4'>
              <span className='text-gray-500 text-sm '>Don't have an account?<a href="/register" className='text-blue-500 hover:underline ml-1'>Register now</a></span>
            </div>
          </div>
          
        </div>
       </div>
    );
}
export default Login;