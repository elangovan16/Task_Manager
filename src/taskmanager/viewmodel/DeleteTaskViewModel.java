package taskmanager.viewmodel;

import taskmanager.repository.TaskManagerRepository;
import taskmanager.view.DeleteTaskView;

public class DeleteTaskViewModel {
	private DeleteTaskView deleteTaskView;

	public DeleteTaskViewModel(DeleteTaskView deleteTaskView) {
		this.deleteTaskView = deleteTaskView;
	}

	public void deleteTask(int id) {
		boolean res = TaskManagerRepository.getInstance().deleteTask(id);

		if (res) {
			deleteTaskView.onSuccess("Deleted Successful");
		} else {
			deleteTaskView.onError("ID not found");
		}
	}

}
