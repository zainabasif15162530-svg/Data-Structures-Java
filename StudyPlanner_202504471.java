
//


import java.util.ArrayList;

public class StudyPlanner_202504471 {

    // Part: A
    private ArrayList<String> subjects;
    private ArrayList<String> tasks;
    private ArrayList<Integer> priorities;
    private ArrayList<String> deadlines;
    private ArrayList<String> status;
    private int size;

    // Part: B
    public StudyPlanner_202504471() {
        subjects = new ArrayList<String>(10);
        tasks = new ArrayList<String>(10);
        priorities = new ArrayList<Integer>(10);
        deadlines = new ArrayList<String>(10);
        status = new ArrayList<String>(10);
        size = 0;
    }

    public StudyPlanner_202504471(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        }

        subjects = new ArrayList<String>(capacity);
        tasks = new ArrayList<String>(capacity);
        priorities = new ArrayList<Integer>(capacity);
        deadlines = new ArrayList<String>(capacity);
        status = new ArrayList<String>(capacity);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Part :C
    private int findSubject(String subject) {
        for (int i = 0; i < size; i++) {
            if (subjects.get(i).equals(subject)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String subject) {
        return findSubject(subject) != -1;
    }
    // validates input data and adds a new task to the planner

    public boolean addTask(String subject, String task, int priority, String deadline) {
        if (subject == null || subject.isEmpty()) {
            return false;
        }
        if (task == null || task.isEmpty()) {
            return false;
        }
        if (findSubject(subject) != -1) {
            return false;
        }
        if (priority < 1 || priority > 3) {
            return false;
        }

        if (deadline == null || deadline.length() != 10
                || deadline.charAt(2) != '/' || deadline.charAt(5) != '/') {
            return false;
        }
        String[] parts = deadline.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        int maxDay;
        if (month == 2) {
            maxDay = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxDay) {
            return false;
        }

        subjects.add(subject);
        tasks.add(task);
        priorities.add(priority);
        deadlines.add(deadline);
        status.add("Pending");
        size++;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return subjects.get(index);
    }

    public String getTask(String subject) {
        int i = findSubject(subject);
        if (i == -1) {
            return null;
        }
        return tasks.get(i);
    }

    public int getPriority(String subject) {
        int i = findSubject(subject);
        if (i == -1) {
            return -1;
        }
        return priorities.get(i);
    }

    public String getDeadline(String subject) {
        int i = findSubject(subject);
        if (i == -1) {
            return null;
        }
        return deadlines.get(i);
    }

    public String getStatus(String subject) {
        int i = findSubject(subject);
        if (i == -1) {
            return null;
        }
        return status.get(i);
    }
    // Modifies the priority level of a subject
    public boolean changePriority(String subject, int newPriority) {
        int i = findSubject(subject);
        if (i == -1 || newPriority < 1 || newPriority > 3) {
            return false;
        }
        priorities.set(i, newPriority);
        return true;
    }
    // Modifies the progress status for a specific task
    public boolean updateStatus(String subject, String newStatus) {
        int i = findSubject(subject);
        if (i == -1) {
            return false;
        }
        if (newStatus == null || !(newStatus.equals("Pending")
                || newStatus.equals("In Progress") || newStatus.equals("Completed"))) {
            return false;
        }
        status.set(i, newStatus);
        return true;
    }

    public boolean updateDeadline(String subject, String newDeadline) {
        int i = findSubject(subject);
        if (i == -1) {
            return false;
        }

        if (newDeadline == null || newDeadline.length() != 10
                || newDeadline.charAt(2) != '/' || newDeadline.charAt(5) != '/') {
            return false;
        }
        String[] parts = newDeadline.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        int maxDay;
        if (month == 2) {
            maxDay = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxDay) {
            return false;
        }

        deadlines.set(i, newDeadline);
        return true;
    }

    // Part: F
    public boolean removeTask(String subject) {
        int i = findSubject(subject);
        if (i == -1) {
            return false;
        }
        subjects.remove(i);
        tasks.remove(i);
        priorities.remove(i);
        deadlines.remove(i);
        status.remove(i);
        size--;
        return true;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        String removedSubject = subjects.remove(index);
        tasks.remove(index);
        priorities.remove(index);
        deadlines.remove(index);
        status.remove(index);
        size--;
        return removedSubject;
    }

    public int removeTasksByStatus(String targetStatus) {
        if (targetStatus == null || !(targetStatus.equals("Pending")
                || targetStatus.equals("In Progress") || targetStatus.equals("Completed"))) {
            return 0;
        }
        int removed = 0;
        for (int i = 0; i < size; i++) {
            if (status.get(i).equals(targetStatus)) {
                subjects.remove(i);
                tasks.remove(i);
                priorities.remove(i);
                deadlines.remove(i);
                status.remove(i);
                size--;
                removed++;
                i--;
            }
        }
        return removed;
    }

    // Part: G
    public int countByStatus(String targetStatus) {
        if (targetStatus == null || !(targetStatus.equals("Pending")
                || targetStatus.equals("In Progress") || targetStatus.equals("Completed"))) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (status.get(i).equals(targetStatus)) {
                count++;
            }
        }
        return count;
    }

    public int countCompletedTasks() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (status.get(i).equals("Completed")) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<String> getHighPriorityTasks() {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (priorities.get(i) == 1) {
                result.add(subjects.get(i));
            }
        }
        return result;
    }

    public ArrayList<String> getTasksByPriority(int priority) {
        ArrayList<String> result = new ArrayList<String>();
        if (priority < 1 || priority > 3) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            if (priorities.get(i) == priority) {
                result.add(subjects.get(i));
            }
        }
        return result;
    }

    public ArrayList<String> getCompletedTasks() {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (status.get(i).equals("Completed")) {
                result.add(subjects.get(i));
            }
        }
        return result;
    }

    public ArrayList<String> getOverdueTasks(String today) {
        ArrayList<String> result = new ArrayList<String>();

        // Validate DD/MM/YYYY
        if (today == null || today.length() != 10
                || today.charAt(2) != '/' || today.charAt(5) != '/') {
            return result;
        }
        String[] parts = today.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        int maxDay;
        if (month == 2) {
            maxDay = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxDay) {
            return result;
        }

        String todayKey = parts[2] + parts[1] + parts[0];
        for (int i = 0; i < size; i++) {
            String[] d = deadlines.get(i).split("/");
            String key = d[2] + d[1] + d[0];
            if (!status.get(i).equals("Completed") && key.compareTo(todayKey) < 0) {
                result.add(subjects.get(i));
            }
        }
        return result;
    }

    public String getNextDeadline() {
        String best = null;
        String bestKey = "";
        for (int i = 0; i < size; i++) {
            if (!status.get(i).equals("Completed")) {
                String[] d = deadlines.get(i).split("/");
                String key = d[2] + d[1] + d[0];
                if (best == null || key.compareTo(bestKey) < 0) {
                    best = subjects.get(i);
                    bestKey = key;
                }
            }
        }
        return best;
    }


    // Part: H - Display all study tasks with their details
    public void printPlanner() {
        System.out.println("      Study Planner");
        System.out.println("-------------------------");
        if (size == 0) {
            System.out.println("The study planner is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            int p = priorities.get(i);
            String name;
            if (p == 1) {
                name = "High";
            } else if (p == 2) {
                name = "Medium";
            } else {
                name = "Low";
            }
            System.out.println("Subject: " + subjects.get(i));
            System.out.println("Task: " + tasks.get(i));
            System.out.println("Priority: " + p + " (" + name + ")");
            System.out.println("Deadline: " + deadlines.get(i));
            System.out.println("Status: " + status.get(i));
            System.out.println("-------------------------");
        }
    }

}