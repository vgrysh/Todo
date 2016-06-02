package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/get")
    public List<Map> index() {
        List<Map> tasks = new ArrayList<>();
        taskRepository.findAll().stream().forEach(s -> tasks.add(s.toMap()));
        return tasks;
    }


    @RequestMapping("/")
    public void init() {
        List<Task> tasks = new TaskInitializer().getTasks();
        tasks.stream().forEach(task -> taskRepository.save(task));
    }

}
