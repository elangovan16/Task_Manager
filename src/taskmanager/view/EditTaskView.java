package taskmanager.view;

import java.util.Scanner;

import taskmanager.dto.Task;
import taskmanager.viewmodel.EditTaskViewModel;

public class EditTaskView {
	private EditTaskViewModel editTaskViewModel;

	public EditTaskView() {
		editTaskViewModel = new EditTaskViewModel(this);
	}

	public void editTask() {
		Scanner sc = new Scanner(System.in);
		int id;
		while (true) {
			System.out.print("Enter task ID to edit : ");
			if (sc.hasNextInt()) {
				id = sc.nextInt();
				sc.nextLine();
				if (id > 0) {
					break;
				}
			} else {
				System.err.println("Enter a Valid Number");
				sc.nextLine();
			}

		}
		System.out.print("Enter new title (leave blank to keep existing) : ");
		String title = sc.nextLine();
		System.out.print("Enter new description (leave blank to keep existing) : ");
		String description = sc.nextLine();
		System.out.print("Enter new priority (leave blank to keep existing) : ");
		String priority = sc.nextLine();
		System.out.print("Enter new ststus (leave blank to keep existing) : ");
		String ststus = sc.nextLine();

		Task newTask = new Task(id, title, description, priority, ststus);

		editTaskViewModel.editTask(newTask);

	}

	public void onSuccess(String sus) {
		System.out.println(sus + "\n");
	}

	public void onError(String err) {
		System.out.println(err + "\n");
	}
}