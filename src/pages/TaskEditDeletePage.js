import React, { useState } from "react";
import { useParams } from "react-router-dom";

const TaskEditDeletePage = () => {
  const { id } = useParams();  // Get task ID from URL
  const [taskTitle, setTaskTitle] = useState("");
  const [taskDescription, setTaskDescription] = useState("");

  const handleUpdate = () => {
    console.log("Task Updated:", id, taskTitle, taskDescription);
  };

  const handleDelete = () => {
    console.log("Task Deleted:", id);
  };

  return (
    <div>
      <h2>Edit/Delete Task {id}</h2>
      <form>
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
        <button type="button" onClick={handleUpdate}>Update Task</button>
        <button type="button" onClick={handleDelete}>Delete Task</button>
      </form>
    </div>
  );
};

export default TaskEditDeletePage;
