package task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String assignee;

    protected Task() {
    }

    public Task(String title, String description, String assignee) {
        this.title = title;
        this.description = description;
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }

    public void apply(Task task) {
        title = task.title;
        description = task.description;
        assignee = task.assignee;
    }

    public Map toMap() {
        Map map = new HashMap<>();
        map.put("id", this.id);
        map.put("title", this.title);
        map.put("description", this.description);
        map.put("assignee", this.assignee);
        return map;
    }
}
