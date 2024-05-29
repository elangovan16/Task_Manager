package taskmanager.view;

import java.util.List;
import java.util.Scanner;

import taskmanager.dto.Task;
import taskmanager.viewmodel.FilterTasksByPriorityViewModel;

public class FilterTasksByPriorityView {
	private FilterTasksByPriorityViewModel filterTasksByPriorityViewModel;

	public FilterTasksByPriorityView() {
		filterTasksByPriorityViewModel = new FilterTasksByPriorityViewModel(this);
	}

	public void filterTasksByPriority() {
		Scanner sc = new Scanner(System.in);
		String pri;

		while (true) {
			System.out.print("Enter priority to filter tasks (High/Medium/Low) : ");
			pri = sc.nextLine();
			if (pri.equals("High") || pri.equals("Medium") || pri.equals("Low")) {
				break;
			} else {
				System.err.println("Enter valid priority");
			}
		}

		List<Task> tasks = filterTasksByPriorityViewModel.getTasksByPriority(pri);

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
