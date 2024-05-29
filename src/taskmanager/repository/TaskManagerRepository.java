package taskmanager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import taskmanager.dto.Task;

public class TaskManagerRepository {
	private static TaskManagerRepository repository;

	private TaskManagerRepository() {

	}

	public static TaskManagerRepository getInstance() {
		if (repository == null) {
			repository = new TaskManagerRepository();
		}
		return repository;
	}

	public boolean addTask(Task task) {
		String query = "INSERT INTO task(title,description,priority,status) VALUES(?,?,?,?)";
		boolean rowUpdated = false;
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, task.getTitle());
			pstmt.setString(2, task.getDescription());
			pstmt.setString(3, task.getPriority());
			pstmt.setString(4, task.getStatus());
			rowUpdated = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}

		return rowUpdated;
	}

	public boolean deleteTask(int id) {
		String query = "DELETE FROM task WHERE id = ?";
		boolean rowUpdated = false;
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rowUpdated = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
		return rowUpdated;
	}

	public Task getTaskById(int id) {
		Task task = null;
		String query = "SELECT * FROM task WHERE id = ?";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				task = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("priority"), rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}

	public boolean editTask(Task newTask) {
		boolean rowUpdated = false;
		String query = "UPDATE task SET title = ?, description = ?, priority = ?,status = ? WHERE id = ?;";
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, newTask.getTitle());
			pstmt.setString(2, newTask.getDescription());
			pstmt.setString(3, newTask.getPriority());
			pstmt.setString(4, newTask.getStatus());
			pstmt.setInt(5, newTask.getId());
			rowUpdated = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public List<Task> filterTasksByPriority(String pri) {
		String query = "SELECT * FROM task WHERE priority = ?";
		List<Task> res = new ArrayList<>();
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, pri);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Task task = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("priority"), rs.getString("status"));
				res.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<Task> viewAllTasks() {
		String query = "SELECT * FROM task";
		List<Task> res = new ArrayList<>();
		try {
			Connection con = GetConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Task task = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("priority"), rs.getString("status"));

				res.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}