package part1;
/*
*Student Number: ST10312691
 * Full Name: Oratile Mmusi
 * Description: POE PART 2 
 * 
*/
public class Task {

    private String taskName;
    private String developer;
    private int duration;
    private String status;
    private String taskID; // Unique task ID

    // Constructor
    public Task(String taskName, String developer, int duration, String status) {
        this.taskName = taskName;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.taskID = generateTaskID(); // Generate a unique task ID for each task
    }

    // Getter for Developer
    public String getDeveloper() {
        return developer;
    }

    // Getter for Task Details
    public String displayTaskDetails() {
        return "Task ID: " + taskID + "\nTask Name: " + taskName + "\nDeveloper: " + developer + "\nDuration: " + duration + " hours\nStatus: " + status;
    }

    // Generate a unique Task ID
    private String generateTaskID() {
        return "TASK" + (int)(Math.random() * 10000);  // Simple random ID generation
    }

    // Getter for Duration
    public int getDuration() {
        return duration;
    }

    // Getter for Status
    public String getStatus() {
        return status;
    }

    // Getter for Task ID
    public String getTaskID() {
        return taskID;
    }

    // Implemented method to return the task's name
    public String getTaskName() {
        return taskName;
    }

    // Method to create Task ID - Simply returns the already generated task ID
    public String createTaskID() {
        return taskID;
    }
}
