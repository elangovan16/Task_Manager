package taskmanager.view;

import java.util.Scanner;

import taskmanager.viewmodel.DeleteTaskViewModel;

public class DeleteTaskView {
	private DeleteTaskViewModel deleteTaskViewModel;

	public DeleteTaskView() {
		deleteTaskViewModel = new DeleteTaskViewModel(this);
	}

	public void deleteTask() {
		Scanner sc = new Scanner(System.in);
		int id = 0;

		while (true) {
			System.out.print("Enter task ID to delete : ");
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

		deleteTaskViewModel.deleteTask(id);
	}

	public void onSuccess(String sus) {
		System.out.println(sus + "\n");
	}

	public void onError(String err) {
		System.out.println(err + "\n");
	}
}
