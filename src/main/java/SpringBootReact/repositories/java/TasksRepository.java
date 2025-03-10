package SpringBootReact.repositories.java;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootReact.entity.Tasks;
@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long>{

}