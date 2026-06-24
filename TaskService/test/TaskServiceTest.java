/*
 * CS 320 Module Four Milestone
 * Task Service Project
 * Developer: Justin Carlo Florida
 * Date: May 29, 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {

    // Test adding valid task
    @Test
    void testAddTask() {

        TaskService service = new TaskService();

        Task task = new Task("12345", "Task Name", "Task Description");

        service.addTask(task);

        assertTrue(service.getTask("12345").equals(task));
    }

    // Test duplicate task ID
    @Test
    void testAddDuplicateTask() {

        TaskService service = new TaskService();

        Task task1 = new Task("12345", "Task One", "Task Description");
        Task task2 = new Task("12345", "Task Two", "Task Description");

        service.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    // Test deleting task
    @Test
    void testDeleteTask() {

        TaskService service = new TaskService();

        Task task = new Task("12345", "Task Name", "Task Description");

        service.addTask(task);

        service.deleteTask("12345");

        assertNull(service.getTask("12345"));
    }

    // Test invalid delete task ID
    @Test
    void testDeleteInvalidTaskId() {

        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("99999");
        });
    }

    // Test updating task name
    @Test
    void testUpdateTaskName() {

        TaskService service = new TaskService();

        Task task = new Task("12345", "Task Name", "Task Description");

        service.addTask(task);

        service.updateTaskName("12345", "Updated Name");

        assertTrue(service.getTask("12345").getName().equals("Updated Name"));
    }

    // Test updating task description
    @Test
    void testUpdateTaskDescription() {

        TaskService service = new TaskService();

        Task task = new Task("12345", "Task Name", "Task Description");

        service.addTask(task);

        service.updateTaskDescription("12345", "Updated Description");

        assertTrue(service.getTask("12345").getDescription().equals("Updated Description"));
    }

    // Test invalid task ID update
    @Test
    void testUpdateInvalidTaskId() {

        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("99999", "Updated Name");
        });
    }
}