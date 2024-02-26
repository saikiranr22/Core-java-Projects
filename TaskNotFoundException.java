package edu.jsp.taskmanager.model.exception;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(int id) {
		super("Task not found with id : " + id);

	}
}
