package uz.pdp.task_management_system.service;

import org.springframework.stereotype.Repository;
import uz.pdp.task_management_system.domain.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Repository
public class TaskService {
    public List<Task> sortByStatus(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getStat));
        return tasks;
    }

    public List<Task> sortByDeadline(List<Task> tasks) {
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                return task1.getDeadline().compareTo(task2.getDeadline());
            }
        });
        return tasks;
    }
}
