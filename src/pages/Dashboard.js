import React from "react";
import { Container, Card, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function Dashboard() {
  return (
    <Container className="mt-5">
      <Card className="p-4 shadow">
        <h2 className="text-center">Dashboard</h2>
        <div className="d-flex justify-content-center gap-3 mt-3">
          <Button variant="primary">
            <Link to="/tasks/create" className="text-white text-decoration-none">Create Task</Link>
          </Button>
          <Button variant="success">
            <Link to="/tasks" className="text-white text-decoration-none">View Tasks</Link>
          </Button>
        </div>
      </Card>
    </Container>
  );
}

export default Dashboard;
