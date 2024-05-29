package taskmanager.view;

import java.util.Scanner;

import taskmanager.dto.Task;
import taskmanager.viewmodel.AddTaskViewModel;

public class AddTaskView {
	private AddTaskViewModel addTaskViewModel;

	public AddTaskView() {
		addTaskViewModel = new AddTaskViewModel(this);
	}

	public void addTask() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter task title : ");
		String title = sc.nextLine();
		System.out.print("Enter task description : ");
		String description = sc.nextLine();
		System.out.print("Enter task priority (High/Medium/Low) : ");
		String priority = sc.nextLine();
		System.out.print("Enter task ststus (Pending/In Progress/Completed) : ");
		String ststus = sc.nextLine();

		Task task = new Task(title, description, priority, ststus);

		addTaskViewModel.addTask(task);
	}

	public void onSuccess(String sus) {
		System.out.println(sus + "\n");
	}

	public void onError(String err) {
		System.out.println(err + "\n");
	}
}