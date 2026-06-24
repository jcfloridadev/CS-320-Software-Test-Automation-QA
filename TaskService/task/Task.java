/*
 * CS 320 Module Four Milestone
 * Task Service Project
 * Developer: Justin Carlo Florida
 * Date: May 29, 2026
 */

package task;

public class Task {
	
	// Task variables
    private final String taskId;
    private String name;
    private String description;
    
    // Task constructor
    public Task(String taskId, String name, String description) {
    	
    	// Validate task ID
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        
        // Validate task name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
     
        // Validate task description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        
        // Assign task values
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getter methods
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setter methods  
    public void setName(String name) {

        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }

        this.name = name;
    }

    public void setDescription(String description) {

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.description = description;
    }
}