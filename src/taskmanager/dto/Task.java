package taskmanager.dto;

public class Task {

	private int id;
	private String title;
	private String description;
	private String priority;
	private String status;

	public Task(int id, String title, String description, String priority, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	public Task(String title, String description, String priority, String status) {
		super();
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task ID: " + id + ", Title: " + title + ", Description: " + description + ", Priority: " + priority + ", Status: "
				+ status;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
