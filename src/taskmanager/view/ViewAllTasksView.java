package taskmanager.view;

import java.util.List;

import taskmanager.dto.Task;
import taskmanager.viewmodel.ViewAllTasksViewModel;

public class ViewAllTasksView {
	private ViewAllTasksViewModel viewAllTasksViewModel;

	public ViewAllTasksView() {
		viewAllTasksViewModel = new ViewAllTasksViewModel(this);
	}

	public void viewAllTasks() {
		List<Task> tasks = viewAllTasksViewModel.getAllTasks();

		for (Task t : tasks) {
			System.out.println(t);
		}
		System.out.println();
	}

	public void onSuccess(String sus) {
		System.out.println(sus);
	}

	public void onError(String err) {
		System.err.println(err);
	}
}
