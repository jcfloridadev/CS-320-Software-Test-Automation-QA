/*
 * CS 320 Module Four Milestone
 * Task Service Project
 * Developer: Justin Carlo Florida
 * Date: May 29, 2026
 */

package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    // Store task objects
    private final Map<String, Task> tasks = new HashMap<>();

    // Add task
    public void addTask(Task task) {

        // Validate task object
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Invalid task");
        }

        // Store task in map
        tasks.put(task.getTaskId(), task);
    }

    // Delete task
    public void deleteTask(String taskId) {

        // Validate task ID
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }

        // Remove task from map
        tasks.remove(taskId);
    }

    // Update task name
    public void updateTaskName(String taskId, String name) {

        // Validate task ID
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }

        tasks.get(taskId).setName(name);
    }

    // Update task description
    public void updateTaskDescription(String taskId, String description) {

        // Validate task ID
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }

        tasks.get(taskId).setDescription(description);
    }

    // Retrieve task object
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}