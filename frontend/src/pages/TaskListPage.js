import React from "react";
import { Link } from "react-router-dom";

function TaskListPage() {
  return (
    <div>
      <h2>Task List</h2>
      <Link to="/tasks/new">
        <button>Create New Task</button>
      </Link>
      <ul>
        <li>Task 1 <Link to="/tasks/edit/1">Edit/Delete</Link></li>
        <li>Task 2 <Link to="/tasks/edit/2">Edit/Delete</Link></li>
      </ul>
    </div>
  );
}

export default TaskListPage;
