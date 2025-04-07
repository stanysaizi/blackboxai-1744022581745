import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginForm from './components/Auth/LoginForm';
import './styles/global.css';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginForm />} />
        {/* Additional routes will be added here */}
      </Routes>
    </Router>
  );
};

export default App;