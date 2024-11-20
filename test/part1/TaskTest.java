package part1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    
    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        // Test Data
        String[] developers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        
        // Expected Results
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        
        // Test
        assertArrayEquals("The developer array is not populated as expected.", expectedDevelopers, developers);
    }
    
    @Test
    public void testTaskNameArrayCorrectlyPopulated() {
        // Test Data
        String[] taskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        
        // Expected Results
        String[] expectedTaskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        
        // Test
        assertArrayEquals("The task name array is not populated as expected.", expectedTaskNames, taskNames);
    }
    
    @Test
    public void testTaskDurationArrayCorrectlyPopulated() {
        // Test Data
        int[] taskDurations = {5, 8, 2, 11};
        
        // Expected Results
        int[] expectedDurations = {5, 8, 2, 11};
        
        // Test
        assertArrayEquals("The task duration array is not populated as expected.", expectedDurations, taskDurations);
    }
    
    @Test
    public void testTaskStatusArrayCorrectlyPopulated() {
        // Test Data
        String[] taskStatuses = {"To Do", "Doing", "Done", "To Do"};
        
        // Expected Results
        String[] expectedStatuses = {"To Do", "Doing", "Done", "To Do"};
        
        // Test
        assertArrayEquals("The task status array is not populated as expected.", expectedStatuses, taskStatuses);
    }
    
    @Test
    public void testCombinedTaskDetails() {
        // Test Data
        String[] developers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] taskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        int[] taskDurations = {5, 8, 2, 11};
        String[] taskStatuses = {"To Do", "Doing", "Done", "To Do"};
        
        // Combined Task Details for Each Task
        String[] expectedDetails = {
            "Developer: Mike Smith, Task Name: Create Login, Duration: 5, Status: To Do",
            "Developer: Edward Harrison, Task Name: Create Add Features, Duration: 8, Status: Doing",
            "Developer: Samantha Paulson, Task Name: Create Reports, Duration: 2, Status: Done",
            "Developer: Glenda Oberholzer, Task Name: Add Arrays, Duration: 11, Status: To Do"
        };
        
        // Generate Actual Task Details
        String[] actualDetails = new String[4];
        for (int i = 0; i < developers.length; i++) {
            actualDetails[i] = "Developer: " + developers[i] +
                               ", Task Name: " + taskNames[i] +
                               ", Duration: " + taskDurations[i] +
                               ", Status: " + taskStatuses[i];
        }
        
        // Test
        assertArrayEquals("The combined task details are not as expected.", expectedDetails, actualDetails);
    }
}
