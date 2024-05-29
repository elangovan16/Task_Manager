package taskmanager.viewmodel;

import taskmanager.dto.Task;
import taskmanager.repository.TaskManagerRepository;
import taskmanager.view.EditTaskView;

public class EditTaskViewModel {
	private EditTaskView editTaskView;

	public EditTaskViewModel(EditTaskView editTaskView) {
		this.editTaskView = editTaskView;
	}

	public void editTask(Task task) {
		Task oldTask = TaskManagerRepository.getInstance().getTaskById(task.getId());
		if (oldTask == null) {
			editTaskView.onError("ID not found");
		} else {
			if (task.getTitle().equals("")) {
				oldTask.setTitle(task.getTitle());
			}
			if (task.getDescription().equals("")) {
				oldTask.setDescription(task.getDescription());
			}
			if (task.getPriority().equals("")) {
				oldTask.setPriority(task.getPriority());
			}
			if (task.getStatus().equals("")) {
				oldTask.setStatus(task.getStatus());
			}

			boolean res = TaskManagerRepository.getInstance().editTask(oldTask);

			if (res) {
				editTaskView.onSuccess("Edited Successful");
			} else {
				editTaskView.onError("Some error !");
			}

		}
	}
}
