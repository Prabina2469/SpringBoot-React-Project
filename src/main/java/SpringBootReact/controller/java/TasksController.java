package SpringBootReact.controller.java;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SpringBootReact.entity.Tasks;
import SpringBootReact.repositories.java.TasksRepository;
import SpringBootReact.service.java.TasksService;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;
    private final TasksRepository tasksRepository;

    public TasksController(TasksService tasksService, TasksRepository tasksRepository) {
        this.tasksService = tasksService;
        this.tasksRepository = tasksRepository;
    }


    @GetMapping
    public List<Tasks> getAllTasks() {
        return tasksService.getAllTasks();
    }

    // ✅ FIXED: Removed extra `/tasks`
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Tasks task) {
        System.out.println("Received Task: " + task); // Debug: Check if task is received
        Tasks savedTask = tasksService.createTask(task);
        System.out.println("Saved Task: " + savedTask); // Debug: Check if task is saved
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable Long id) {
        Optional<Tasks> task = tasksService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
        return ResponseEntity.ok().body("Task deleted successfully");
    }


   
}