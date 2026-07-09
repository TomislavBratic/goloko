import { createContext, useContext, useState } from "react";

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [email, setEmail] = useState(localStorage.getItem("email"));
  const [role, setRole] = useState(localStorage.getItem("role"));

  const isAuthenticated = !!token;

  const login = (loginData) => {
    localStorage.setItem("token", loginData.token);
    localStorage.setItem("email", loginData.email);
    localStorage.setItem("role", loginData.role);

    setToken(loginData.token);
    setEmail(loginData.email);
    setRole(loginData.role);
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("email");
    localStorage.removeItem("role");

    setToken(null);
    setEmail(null);
    setRole(null);
  };

  return (
    <AuthContext.Provider
      value={{
        token,
        email,
        role,
        isAuthenticated,
        login,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);