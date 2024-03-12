package edu.jsp.taskmanager.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.taskmanager.Connectionpool.Connectionpool;
import edu.jsp.taskmanager.model.SortByDeadLine;
import edu.jsp.taskmanager.model.SortById;
import edu.jsp.taskmanager.model.SortByName;
import edu.jsp.taskmanager.model.SortByStartDate;
import edu.jsp.taskmanager.model.Task;

public class DBController implements Controller {

	@Override
	public Task saveTask(Task task) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = Connectionpool.getConnection();

			statement = connection.prepareStatement("INSERT INTO TASK VALUES(?,?,?,?,?)");

			statement.setInt(1, task.getId());
			statement.setString(2, task.getName());
			statement.setDate(3, Date.valueOf(task.getStartDate()));
			statement.setDate(4, Date.valueOf(task.getDeadLine()));
			statement.setString(5, task.getDescription());

			int rows = statement.executeUpdate();

			if (rows > 0) {
				return task;
			} else {
				return null;
			}

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					Connectionpool.receiveConnection(connection);
				}
			} catch (Exception exception2) {
				System.out.println(exception2.getMessage());
			}
		}
	}

	@Override
	public Task getTask(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			connection = Connectionpool.getConnection();
			statement = connection.prepareStatement("SELECT * FROM TASK WHERE ID = ?");
			statement.setInt(1, id);

			set = statement.executeQuery();

			if (set.next()) {
				Task task = new Task();

				task.setId(set.getInt(1));
				task.setName(set.getString(2));
				task.setStartDate(LocalDate.parse(String.valueOf(set.getDate(3))));
				task.setStartDate(LocalDate.parse(String.valueOf(set.getDate(4))));
				task.setDescription(set.getString(5));

				return task;

			}

			return null;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;

		} finally {
			try {
				if (set != null) {
					set.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					Connectionpool.receiveConnection(connection);
				}
			} catch (Exception exception2) {
				System.out.println(exception2.getMessage());
			}
		}
	}

	@Override
	public List<Task> getAllTasks() {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		List<Task> tasks = new ArrayList<>();

		try {

			connection = Connectionpool.getConnection();

			statement = connection.prepareStatement("SELECT * FROM TASK");

			set = statement.executeQuery();

			while (set.next()) {
				Task task = new Task();

				task.setId(set.getInt(1));
				task.setName(set.getString(2));
				task.setStartDate(LocalDate.parse(String.valueOf(set.getDate(3))));
				task.setDeadLine(LocalDate.parse(String.valueOf(set.getDate(4))));
				task.setDescription(set.getString(5));

				tasks.add(task);
			}
			return tasks;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		} finally {
			try {
				if (set != null) {
					set.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					Connectionpool.receiveConnection(connection);
				}
			} catch (Exception exception2) {
				System.out.println(exception2.getMessage());
			}
		}
	}


	@Override
	public boolean deleteTask(Task task) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = Connectionpool.getConnection();
			
			statement = connection.prepareStatement("DELETE FROM TASK WHERE ID = ?");
			
			statement.setInt(1, task.getId());
			
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
			return false;
		}finally {
			try {
				if(statement !=null) {
					statement.close();
				}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				Connectionpool.receiveConnection(connection);
			}
		} catch(Exception exception2) {
			System.out.println(exception2.getMessage());
		}
	}
}
	@Override
	public List<Task> sortTasks(Comparator<Task> comparator) {

		List<Task> tasks = getAllTasks();

		if (comparator instanceof SortById) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByName) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByStartDate) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByDeadLine) {
			Collections.sort(tasks, comparator);
		}
		return tasks;
	}

	@Override
	public List<Task> getAllTasks(Comparator<Task> comparator) {
		// TODO Auto-generated method stub
		return sortTasks(comparator);
	}

}
