
//

public class Q1Demo {
    public static void main(String[] args) {
        StudyPlanner_202504471 planner = new StudyPlanner_202504471();

        planner.addTask("Data Structures", "Practice ArrayList exercises", 1, "15/10/2026");
        planner.addTask("Database Systems", "Complete SQL exercises", 2, "08/10/2026");
        planner.addTask("Mathematics", "Solve Assignment", 1, "20/10/2026");
        planner.addTask("Computer Networks", "Read Chapter 3", 3, "12/10/2026");
        planner.addTask("Software Engineering", "Prepare project proposal", 1, "18/10/2026");

        planner.updateStatus("Data Structures", "In Progress");
        planner.updateStatus("Mathematics", "Completed");
        planner.updateStatus("Software Engineering", "In Progress");

        planner.printPlanner();

        System.out.println("Number of tasks: " + planner.getSize());
        String first = planner.get(0);
        System.out.println("First subject: " + first);
        System.out.println("Task description: " + planner.getTask(first));
        System.out.println("Priority: " + planner.getPriority(first));
        System.out.println("Deadline: " + planner.getDeadline(first));
        System.out.println("Status: " + planner.getStatus(first));
        System.out.println("Pending tasks: " + planner.countByStatus("Pending"));
        System.out.println("Completed tasks: " + planner.countCompletedTasks());
        System.out.println("High-priority tasks: " + planner.getHighPriorityTasks());
        System.out.println("Priority 3 tasks: " + planner.getTasksByPriority(3));
        System.out.println("Completed subjects: " + planner.getCompletedTasks());
        System.out.println("Next deadline: " + planner.getNextDeadline());
        System.out.println("Overdue tasks: " + planner.getOverdueTasks("10/10/2026"));

        System.out.println("Removed subject: " + planner.remove(0));
        System.out.println("Database Systems removed: " + planner.removeTask("Database Systems"));
        System.out.println("Pending tasks removed: " + planner.removeTasksByStatus("Pending"));

        System.out.println("Remaining tasks: " + planner.getSize());
        planner.printPlanner();
    }
}
