package task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByAssignee(String name);

    List<Task> findAll();
}
