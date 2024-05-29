package taskmanager.viewmodel;

import java.util.List;

import taskmanager.dto.Task;
import taskmanager.repository.TaskManagerRepository;
import taskmanager.view.ViewAllTasksView;

public class ViewAllTasksViewModel {

	private ViewAllTasksView viewAllTasksView;

	public ViewAllTasksViewModel(ViewAllTasksView viewAllTasksView) {
		this.viewAllTasksView = viewAllTasksView;
	}

	public List<Task> getAllTasks() {
		return TaskManagerRepository.getInstance().viewAllTasks();
	}

}
