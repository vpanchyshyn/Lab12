package ua.edu.ucu.apps.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks;

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task: tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        StampingAPI stamp = new StampingAPI(groupUuid);
        this.visit(stamp);
        for (Task<T> task: tasks) {
            task.visit(stamp);
            task.apply(arg);
        }
    }
}
