package SpringBootReact.service.java;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringBootReact.entity.Tasks;
import SpringBootReact.repositories.java.TasksRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class TasksService {
    
    private final TasksRepository tasksRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    
    @Transactional
    public Tasks createTask(Tasks task) {
        try {
            System.out.println("🔹 Before Saving Task: " + task);
            Tasks savedTask = tasksRepository.save(task);
            tasksRepository.flush(); // Force commit
            System.out.println("✅ After Saving Task: " + savedTask);
            return savedTask;
        } catch (Exception e) {
            System.out.println("❌ Error while saving task: " + e.getMessage());
            throw e;
        }
    }



    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();  // Get all tasks
    }

    public Optional<Tasks> getTaskById(Long id) {
        return tasksRepository.findById(id);  // Get task by id
    }

    @Transactional
    public Tasks updateTask(Long id, Tasks taskDetails) {
        return tasksRepository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setPriority(taskDetails.getPriority());
            return tasksRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Transactional
    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }
}
