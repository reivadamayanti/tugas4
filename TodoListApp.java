import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> todoList;

    public TodoListApp() {
        todoList = new ArrayList<>();
    }

    public void addTask(String task) {
        todoList.add(task);
    }

    public void removeTask(String task) {
        if (todoList.remove(task)) {
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    public void removeTaskByIndex(int index) {
        if (index >= 0 && index < todoList.size()) {
            String removedTask = todoList.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Please enter a valid index (number 0 - " + (todoList.size() - 1) + ")");
        }
    }

    public void displayTasks() {
        if (todoList.isEmpty()) {
            System.out.println("Your To-Do List is empty ");
        } else {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(i + ": " + todoList.get(i));
            }
        }
    }

    public void searchTask(String task) {
        if (todoList.contains(task)) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found");
        }
    }

    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task By Task Name");
            System.out.println("3. Remove Task By Index");
            System.out.println("4. Search Task By Name");
            System.out.println("5. Display Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextInt()) {  // Validasi input agar tidak crash jika user memasukkan huruf
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.next();  // Bersihkan input yang salah
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    app.addTask(taskToAdd);
                    break;

                case 2:
                    System.out.print("Enter task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    app.removeTask(taskToRemove);
                    break;

                case 3:
                    System.out.print("Enter index to remove: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid index.");
                        scanner.next();
                        break;
                    }
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Bersihkan buffer
                    app.removeTaskByIndex(indexToRemove);
                    break;

                case 4:
                    System.out.print("Enter task name to search: ");
                    String taskToSearch = scanner.nextLine();
                    app.searchTask(taskToSearch);
                    break;

                case 5:
                    app.displayTasks();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
