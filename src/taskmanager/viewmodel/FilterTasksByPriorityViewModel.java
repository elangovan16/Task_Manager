package taskmanager.viewmodel;

import java.util.List;

import taskmanager.dto.Task;
import taskmanager.repository.TaskManagerRepository;
import taskmanager.view.FilterTasksByPriorityView;

public class FilterTasksByPriorityViewModel {
	private FilterTasksByPriorityView filterTasksByPriorityView;

	public FilterTasksByPriorityViewModel(FilterTasksByPriorityView filterTasksByPriorityView) {
		this.filterTasksByPriorityView = filterTasksByPriorityView;
	}

	public List<Task> getTasksByPriority(String pri) {
		return TaskManagerRepository.getInstance().filterTasksByPriority(pri);
	}

}
