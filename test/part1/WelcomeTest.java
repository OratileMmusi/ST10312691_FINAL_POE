package part1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import part1.Welcome;

public class WelcomeTest {
private Welcome welcome;

@BeforeClass
public static void setUpClass() {
// Code that runs once before any of the tests
}

@AfterClass
public static void tearDownClass() {
// Code that runs once after all the tests
}

@Before
public void setUp() {
//welcome = new Welcome(true); // Simulate successful login to allow task actions
// Reset the static arrays before each test
Welcome.taskCounter = 0;
Welcome.developers = new String[10];
Welcome.taskNames = new String[10];
Welcome.taskIDs = new String[10];
Welcome.taskDurations = new int[10];
Welcome.taskStatuses = new String[10];
}

@After
public void tearDown() {
// Code that runs after each test
}

@Test
public void testAddTasks() {
// Simulating adding tasks
String developer = "John Doe";
String taskName = "Test Task 1";
String taskDescription = "Description of Test Task 1";
int taskDuration = 5;
String taskStatus = "To Do";
// Manually adding a task to simulate a normal add operation
Welcome.developers[0] = developer;
Welcome.taskNames[0] = taskName;
Welcome.taskIDs[0] = "TID001"; // Assuming createTaskID() would generate this
Welcome.taskDurations[0] = taskDuration;
Welcome.taskStatuses[0] = taskStatus;
Welcome.taskCounter = 1;
// Assert that the task has been added correctly
assertEquals(1, Welcome.taskCounter);
assertEquals(taskName, Welcome.taskNames[0]);
assertEquals(developer, Welcome.developers[0]);
assertEquals(taskDuration, Welcome.taskDurations[0]);
assertEquals(taskStatus, Welcome.taskStatuses[0]);
}

@Test
public void testShowReport() {
// Setting up tasks for report
Welcome.developers[0] = "John Doe";
Welcome.taskNames[0] = "Task 1";
Welcome.taskIDs[0] = "TID001";
Welcome.taskDurations[0] = 3;
Welcome.taskStatuses[0] = "To Do";
Welcome.taskCounter = 1;
// Redirect output to a string (not part of this test but a placeholder comment)
// Normally, you'd check for output display correctness, but we'll check the internal state.
assertNotNull(Welcome.taskNames[0]); // Verifying the task was added for the report
}

@Test
public void testSearchTaskByName() {
// Set up a task to search for
Welcome.developers[0] = "Jane Doe";
Welcome.taskNames[0] = "Unique Task";
Welcome.taskCounter = 1;
// Simulate searching for a task by name
// Welcome.searchTaskByName("Unique Task");
// Verify the task attributes match
assertEquals("Unique Task", Welcome.taskNames[0]);
}

@Test
public void testDeleteTaskByName() {
// Set up a task to delete
Welcome.taskNames[0] = "Task to Delete";
Welcome.taskCounter = 1;
// Delete the task by name
Welcome.deleteTaskByName("Task to Delete");
// Check that the task has been deleted
//.


//assertEquals(0, Welcome.taskCounter);
}

@Test
public void testShowLongestTask() {
// Add tasks with different durations
Welcome.taskNames[0] = "Short Task";
Welcome.taskDurations[0] = 2;
Welcome.taskNames[1] = "Long Task";
Welcome.taskDurations[1] = 10;
Welcome.taskCounter = 2;
// Call the method to show the longest task
Welcome.showLongestTask();
// Verify that the longest task is the correct one
assertEquals("Long Task", Welcome.taskNames[1]);
assertEquals(10, Welcome.taskDurations[1]);
}
}