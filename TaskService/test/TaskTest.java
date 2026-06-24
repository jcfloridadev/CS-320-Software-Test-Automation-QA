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

class TaskTest {

    // Test valid task object
    @Test
    void testTask() {

        Task task = new Task("12345", "Task Name", "Task Description");

        assertTrue(task.getTaskId().equals("12345"));
        assertTrue(task.getName().equals("Task Name"));
        assertTrue(task.getDescription().equals("Task Description"));
    }

    // Test task ID length validation
    @Test
    void testTaskIdTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task Description");
        });
    }

    // Test null task ID
    @Test
    void testTaskIdNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description");
        });
    }

    // Test name length validation
    @Test
    void testNameTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This task name is too long", "Task Description");
        });
    }

    // Test null name
    @Test
    void testNameNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Task Description");
        });
    }

    // Test description length validation
    @Test
    void testDescriptionTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name",
                    "This task description is definitely longer than fifty characters.");
        });
    }

    // Test null description
    @Test
    void testDescriptionNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name", null);
        });
    }

    // Test updating task name
    @Test
    void testSetName() {

        Task task = new Task("12345", "Task Name", "Task Description");

        task.setName("Updated Name");

        assertTrue(task.getName().equals("Updated Name"));
    }

    // Test updating task description
    @Test
    void testSetDescription() {

        Task task = new Task("12345", "Task Name", "Task Description");

        task.setDescription("Updated Description");

        assertTrue(task.getDescription().equals("Updated Description"));
    }
}