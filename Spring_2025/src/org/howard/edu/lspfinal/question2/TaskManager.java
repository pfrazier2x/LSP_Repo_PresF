package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);  // this will throw if not found
        task.setStatus(newStatus);
    }

    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new HashMap<>();
        for (Task task : tasks.values()) {
            grouped.putIfAbsent(task.getStatus(), new ArrayList<>());
            grouped.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : grouped.keySet()) {
            System.out.println(status + ":");
            for (Task task : grouped.get(status)) {
                System.out.println("  " + task);
            }
        }
    }
}
