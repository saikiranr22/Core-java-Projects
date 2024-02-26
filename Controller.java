package edu.jsp.taskmanager.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import edu.jsp.taskmanager.model.SortByDeadLine;
import edu.jsp.taskmanager.model.SortById;
import edu.jsp.taskmanager.model.SortByName;
import edu.jsp.taskmanager.model.SortByStartDate;
import edu.jsp.taskmanager.model.Task;
import edu.jsp.taskmanager.model.exception.TaskNotFoundException;

public class Controller {

	private List<Task> tasks = new ArrayList<>();

	public Task saveTask(Task task) {

		if (task != null) {
			tasks.add(task);
			return task;
		}
		return null;
	}

	public Task getTask(int id) {

		Iterator<Task> iterator = tasks.iterator();

		while (iterator.hasNext()) {

			Task task = (Task) iterator.next();
			if (task.getId() == id) {
				return task;
			}
		}
		throw new TaskNotFoundException(id);
	}

	public List<Task> getAllTasks() {
		return tasks;
	}

	public List<Task> getAllTasks(Comparator<Task> comparator) {
		return sortTasks(comparator);
	}

	public boolean deleteTask(Task task) {
		if (task != null) {
			tasks.remove(task);
			return true;
		}
		return false;
	}

	public List<Task> sortTasks(Comparator<Task> comparator) {

		if (comparator instanceof SortById) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByName) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByStartDate) {
			Collections.sort(tasks, comparator);
		} else if (comparator instanceof SortByDeadLine) {
			Collections.sort(tasks, comparator);
		} else {
			return tasks;
		}
		return tasks;
	}
}