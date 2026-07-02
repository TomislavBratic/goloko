import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faGoogle, faFacebook, faTwitter } from '@fortawesome/free-brands-svg-icons';
import { faEyeSlash, faEye } from '@fortawesome/free-solid-svg-icons';
import { useState } from 'react';
import api from '../api/axios';

const Register = () => {
const [firstName, setFirstName] = useState("");
const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [repeatPassword, setRepeatPassword] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const [loading, setLoading] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
  const [showRepeatPassword, setShowRepeatPassword] = useState(false);

  const handleSubmit = async () => {
    setLoading(true);
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!firstName || !lastName || !email || !password || !repeatPassword) {
      setError("All fields are required!");
      setLoading(false);
      return;
    }

    if (!emailRegex.test(email)) {
      setError("Enter a valid email address!");
      setLoading(false);
      return;
    }

    if (password.length < 8) {
      setError("Password needs to be at least 8 characters long!");
      setLoading(false);
      return;
    }

    if (password !== repeatPassword) {
      setError("Passwords don't match!");
      setLoading(false);
      return;
    }

    setError('');

    try {
      const response = await api.post("/api/auth/register", {
        firstName,
        lastName,
        email,
        password
      });

      setFirstName('');
      setLastName('');
      setEmail('');
      setPassword('');
      setRepeatPassword('');
      setSuccess('Registration successful!');
      setLoading(false);
    }
   

    catch (err) {
      setError(err.response?.data?.message || "Registration failed.");
      console.error(err);
    } finally {
      setLoading(false);
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
            <img src="/register_sign_without_bg.png" className="w-48 h-48 hover:scale:110 transition:300"></img>
            </div>

            {error && <p className='text-red-600 text-sm text-center mb-2'>{error}</p>}
            {success && <p className='text-green-600 text-sm text-center mb-2'>{success}</p>}

            <input className={`p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 ${error && !firstName ? 'border-red-500' : 'focus:ring-blue-400'}`} placeholder='First name' value={firstName} onChange={(e) => setFirstName(e.target.value)} />
             <input className={`p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 ${error && !lastName ? 'border-red-500' : 'focus:ring-blue-400'}`} placeholder='Last name' value={lastName} onChange={(e) => setLastName(e.target.value)}/>
            <input className={`p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 ${error && (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) ? 'border-red-500' : 'focus:ring-blue-400'}`} placeholder="Email"value={email} onChange={(e)=> setEmail(e.target.value)}/>
            <div className="relative mb-4">
            <input
              type={showPassword ? 'text' : 'password'}
              className="p-3  w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 focus:ring-blue-400 pr-10" // note: pr-10 for space for icon
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <button
              type="button"
              className="absolute top-1/2 right-3 transform -translate-y-1/2 text-gray-500"
              onClick={() => setShowPassword(!showPassword)}
            >
              <FontAwesomeIcon icon={showPassword ? faEyeSlash : faEye} />
            </button>
          </div>
            <input type={ showRepeatPassword ? 'text' : 'password'} className={`p-3 mb-4 w-full border rounded bg-gray-50 focus:outline-none focus:ring-2 ${error && (password !== repeatPassword) ? 'border-red-500' : 'focus:ring-blue-400'}`} placeholder="Repeat password" value={repeatPassword} onChange={(e)=> setRepeatPassword(e.target.value)}></input>

            <div className="flex justify-center mb-4">
              <button disabled={loading} className={`w-1/5 p-3 rounded py-3 transition ${loading ? 'bg-gray-400 cursor-not-allowed' : 'bg-blue-950 text-white hover:bg-green-800 transition'}`} onClick={handleSubmit}>{loading ? 'Registering...' : 'Register' }</button>
              <label className="flex items-center pl-4 gap-2 text-gray-500">
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
                 <FontAwesomeIcon icon={faFacebook}/> Sign up with Facebook
              </button  >
                  <button className='w-3/5 flex items-center justify-center bg-sky-500 hover:bg-sky-600 rounded text-white p-2 gap-2'>
                 <FontAwesomeIcon icon={faTwitter}/> Sign up with Twitter
              </button>
                  <button className='w-3/5 flex items-center justify-center bg-red-600 hover:bg-red-700 rounded text-white p-2 gap-2'>
                 <FontAwesomeIcon icon={faGoogle}/> Sign up with Google
              </button>
            </div>
            <div className='flex justify-center mt-4'>
              <span className='text-gray-500 text-sm '>Already have an account?<a href="/login" className='text-blue-500 hover:underline ml-1'>Login now</a></span>
            </div>
          </div>
          
        </div>
       </div>
    );
  }
   export default Register;