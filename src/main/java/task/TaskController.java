package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Map> getAll() {
        List<Map> tasks = new ArrayList<>();
        taskRepository.findAll().stream().forEach(s -> tasks.add(s.toMap()));
        return tasks;
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public Map get(Long id) {
        Task task = taskRepository.findOne(id);
        return task.toMap();
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Map save(@RequestBody Task task) {
        Task persistedTask = taskRepository.save(task);
        return persistedTask.toMap();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public Map update(@RequestBody Task task, Long id) {
        Task persistedTask = taskRepository.findOne(id);
        persistedTask.apply(task);
        return persistedTask.toMap();
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public void delete(Long id) {
        taskRepository.delete(id);
    }

}
