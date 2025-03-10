import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RegistrationPage from "./pages/RegistrationPage";
import LoginPage from "./pages/LoginPage";
import TaskCreationPage from "./pages/TaskCreationPage";
import TaskEditDeletePage from "./pages/TaskEditDeletePage";
import TaskListPage from "./pages/TaskListPage";
import Dashboard from "./pages/Dashboard";  // ✅ Import Dashboard

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<RegistrationPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/dashboard" element={<Dashboard />} />  {/* ✅ Dashboard Route */}
        <Route path="/tasks" element={<TaskListPage />} />
        <Route path="/tasks/new" element={<TaskCreationPage />} />
        <Route path="/tasks/edit/:id" element={<TaskEditDeletePage />} />
      </Routes>
    </Router>
  );
}

export default App;
