package taskmanager.viewmodel;

import taskmanager.dto.Task;
import taskmanager.repository.TaskManagerRepository;
import taskmanager.view.AddTaskView;

public class AddTaskViewModel {
	private AddTaskView addTaskView;

	public AddTaskViewModel(AddTaskView addTaskView) {
		this.addTaskView = addTaskView;
	}

	public void addTask(Task task) {
		boolean res = TaskManagerRepository.getInstance().addTask(task);
		if (res) {
			addTaskView.onSuccess("Task added Successfull.");
		} else {
			addTaskView.onError("Something is wrong re-enter the task again.");
		}
	}
}
