package part1;
/*
*Student Number: ST10312691
 * Full Name: Oratile Mmusi
 * Description: POE PART 2 
 * 
*/
import java.awt.GridLayout;
import javax.swing.*;
import java.util.ArrayList;

public class Welcome extends javax.swing.JFrame {

    // Global arrays for task storage
    public static String[] developers;
    public static String[] taskIDs;
    public static String[] taskNames;
    public static int[] taskDurations;
    public static String[] taskStatuses;
    public static int taskCounter = 0; // Track the number of tasks added

    static void deleteTaskByName(String task_to_Delete) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Task List for Enhanced Features
    public ArrayList<Task> taskList = new ArrayList<>();

    public Welcome() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome to EasyKanban");

        jButton1.setText("1) Add tasks");
        jButton1.addActionListener(evt -> showAddTaskDialog());

        jButton2.setText("2) Show report");
        jButton2.addActionListener(evt -> showReportDialog());

        jButton3.setText("3) Exit");
        jButton3.addActionListener(evt -> System.exit(0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }

    private void showAddTaskDialog() {
        String input = JOptionPane.showInputDialog(null, "Enter the number of tasks:");
        if (input != null) {
            try {
                int numTasks = Integer.parseInt(input);
                if (numTasks > 0) {
                    // Initialize static arrays
                    developers = new String[numTasks];
                    taskNames = new String[numTasks];
                    taskIDs = new String[numTasks];
                    taskDurations = new int[numTasks];
                    taskStatuses = new String[numTasks];

                    for (int i = 0; i < numTasks; i++) {
                        // Create a modal dialog for task input
                        JDialog dialog = new JDialog(this, "Add Task", true);
                        dialog.setSize(400, 300);
                        dialog.setLocationRelativeTo(null);
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
                        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                        JTextField taskNameField = new JTextField();
                        JTextField developerDetailsField = new JTextField();
                        JTextField durationField = new JTextField();
                        JComboBox<String> taskStatusComboBox = new JComboBox<>(new String[]{"To Do", "Done", "Doing"});

                        panel.add(new JLabel("Task Name:"));
                        panel.add(taskNameField);
                        panel.add(new JLabel("Developer Details:"));
                        panel.add(developerDetailsField);
                        panel.add(new JLabel("Task Duration (hours):"));
                        panel.add(durationField);
                        panel.add(new JLabel("Task Status:"));
                        panel.add(taskStatusComboBox);

                        JButton submitButton = new JButton("Submit");
                        submitButton.addActionListener(e -> {
                            try {
                                String taskName = taskNameField.getText();
                                String developerDetails = developerDetailsField.getText();
                                int taskDuration = Integer.parseInt(durationField.getText());
                                String taskStatus = (String) taskStatusComboBox.getSelectedItem();

                                if (taskName.isEmpty() || developerDetails.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "All fields are required.");
                                    return;
                                }

                                Task task = new Task(taskName, developerDetails, taskDuration, taskStatus);
                                developers[taskCounter] = developerDetails;
                                taskNames[taskCounter] = taskName;
                                taskIDs[taskCounter] = task.createTaskID();
                                taskDurations[taskCounter] = taskDuration;
                                taskStatuses[taskCounter] = taskStatus;

                                taskList.add(task);
                                taskCounter++;

                                JOptionPane.showMessageDialog(null, "Task successfully captured!");
                                dialog.dispose();
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid number for duration.");
                            }
                        });

                        panel.add(submitButton);
                        dialog.add(panel);
                        dialog.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Number of tasks must be greater than zero.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // Show report and additional action buttons in a new window
    private void showReportDialog() {
        JDialog reportDialog = new JDialog(this, "Task Report and Actions", true);
        reportDialog.setSize(500, 400);
        reportDialog.setLocationRelativeTo(this);

        JPanel reportPanel = new JPanel();
        reportPanel.setLayout(new GridLayout(5, 1, 10, 10));
        reportPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton showDoneTasksButton = new JButton("Display Tasks with Status 'Done'");
        JButton longestTaskButton = new JButton("Display Developer and Duration for Longest Task");
        JButton searchTaskButton = new JButton("Search for Task by Name");
        JButton filterDeveloperButton = new JButton("Filter Tasks by Developer");
        JButton deleteTaskButton = new JButton("Delete Task by Developer");

        // Action listeners for each button
        showDoneTasksButton.addActionListener(e -> showDoneTasks());
        longestTaskButton.addActionListener(e -> showLongestTask());
        searchTaskButton.addActionListener(e -> searchTaskByName());
        filterDeveloperButton.addActionListener(e -> filterTasksByDeveloper());
        deleteTaskButton.addActionListener(e -> deleteTaskByDeveloper());

        reportPanel.add(showDoneTasksButton);
        reportPanel.add(longestTaskButton);
        reportPanel.add(searchTaskButton);
        reportPanel.add(filterDeveloperButton);
        reportPanel.add(deleteTaskButton);

        reportDialog.add(reportPanel);
        reportDialog.setVisible(true);
    }

    private void showDoneTasks() {
        // Display tasks with status "Done"
        StringBuilder report = new StringBuilder("Tasks with status 'Done':\n");
        for (Task task : taskList) {
            if ("Done".equalsIgnoreCase(task.getStatus())) {
                report.append(task.displayTaskDetails()).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No tasks found with status 'Done'.");
    }

    void showLongestTask() {
        // Display developer and duration for the longest task
        Task longestTask = null;
        int maxDuration = 0;
        for (Task task : taskList) {
            if (task.getDuration() > maxDuration) {
                longestTask = task;
                maxDuration = task.getDuration();
            }
        }
        JOptionPane.showMessageDialog(null, longestTask != null ?
                "Longest Task: " + longestTask.getTaskID() + "\nDeveloper: " + longestTask.getDeveloper() +
                        "\nDuration: " + longestTask.getDuration() + " hours" :
                "No tasks available.");
    }

    private void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to Search:");
        if (taskName != null) {
            StringBuilder report = new StringBuilder("Search Results for: " + taskName + "\n");
            for (Task task : taskList) {
                if (task.getTaskName().equalsIgnoreCase(taskName)) {
                    report.append(task.displayTaskDetails()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No tasks found with that name.");
        }
    }

    private void filterTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog("Enter Developer Name to Filter:");
        if (developer != null) {
            StringBuilder report = new StringBuilder("Tasks for Developer: " + developer + "\n");
            for (Task task : taskList) {
                if (task.getDeveloper().equalsIgnoreCase(developer)) {
                    report.append(task.displayTaskDetails()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No tasks found for this developer.");
        }
    }

    private void deleteTaskByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter developer's name to delete tasks:");
        if (developerName != null && !developerName.trim().isEmpty()) {
            boolean found = false;
            // Remove tasks from the list
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                if (task.getDeveloper().equalsIgnoreCase(developerName)) {
                    taskList.remove(i);
                    i--;  // Adjust index after removal
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, "Tasks assigned to " + developerName + " have been deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "No tasks found for the developer: " + developerName);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid developer name.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Welcome().setVisible(true));
    }

    // UI Components
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
}
