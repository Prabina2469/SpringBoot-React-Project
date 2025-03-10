import React, { useState } from "react";

const TaskCreationPage = () => {
  const [taskTitle, setTaskTitle] = useState("");
  const [taskDescription, setTaskDescription] = useState("");

  const handleCreateTask = (event) => {
    event.preventDefault();
    console.log("Task Created:", taskTitle, taskDescription);
  };

  return (
    <div>
      <h2>Create Task</h2>
      <form onSubmit={handleCreateTask}>
        <input 
          type="text" 
          placeholder="Task Title" 
          required 
          value={taskTitle}
          onChange={(e) => setTaskTitle(e.target.value)}
        /><br />
        <textarea 
          placeholder="Task Description" 
          required 
          value={taskDescription}
          onChange={(e) => setTaskDescription(e.target.value)}
        ></textarea><br />
        <button type="submit">Create Task</button>
      </form>
    </div>
  );
};

export default TaskCreationPage;
