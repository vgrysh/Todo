package task;

import java.util.ArrayList;
import java.util.List;

public class TaskInitializer {

    List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("title1", "description1", "user1"));
        tasks.add(new Task("title2", "description2", "user1"));
        tasks.add(new Task("title3", "description3", "user2"));
        tasks.add(new Task("title4", "description4", "user2"));
        tasks.add(new Task("title5", "description5", "user3"));
        return tasks;
    }
}
