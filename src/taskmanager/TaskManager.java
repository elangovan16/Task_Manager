package taskmanager;

import java.util.Scanner;

import taskmanager.view.AddTaskView;
import taskmanager.view.DeleteTaskView;
import taskmanager.view.EditTaskView;
import taskmanager.view.FilterTasksByPriorityView;
import taskmanager.view.ViewAllTasksView;

public class TaskManager {

	public static void main(String[] args) {
		TaskManager app = new TaskManager();
		app.start();
	}

	private void start() {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int choice;
		do {
			info();
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1 -> {
					AddTaskView add = new AddTaskView();
					add.addTask();
				}
				case 2 -> {
					EditTaskView edit = new EditTaskView();
					edit.editTask();
				}
				case 3 -> {
					DeleteTaskView delete = new DeleteTaskView();
					delete.deleteTask();
				}
				case 4 -> {
					ViewAllTasksView allTasks = new ViewAllTasksView();
					allTasks.viewAllTasks();
				}
				case 5 -> {
					FilterTasksByPriorityView filterTasks = new FilterTasksByPriorityView();
					filterTasks.filterTasksByPriority();
				}
				case 6 -> {
					run = false;
				}
				default -> {
					System.err.println("Invalid Choice. Please enter a number from 1 to 6.\n");
				}
				}
			} catch (Exception e) {
				System.err.println("Invalid Choice. Please enter a number from 1 to 6.\n");
				sc.nextLine();
			}

		} while (run);
		System.out.println("Task Manager was Closed. ");
		sc.close();
	}

	private void info() {
		System.out.println("1. Add Task");
		System.out.println("2. Edit Task");
		System.out.println("3. Delete Task");
		System.out.println("4. View All Tasks");
		System.out.println("5. Filter Tasks By Priority");
		System.out.println("6. Exit \n");
		System.out.print("Enter your choice(1-6): ");
	}
}