import React from 'react';
import './LoginForm.css';

interface LoginFormProps {
  // Props can be added here as needed
}

const LoginForm: React.FC<LoginFormProps> = () => {
  return (
    <div className="login-container">
      <h2>Ministry of ICT Attendance System</h2>
      <form>
        <div className="form-group">
          <label htmlFor="username">Username</label>
          <input type="text" id="username" />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input type="password" id="password" />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default LoginForm;