package edu.jsp.taskmanager.controller;

import java.util.Comparator;
import java.util.List;

import edu.jsp.taskmanager.model.Task;

public interface Controller  {
       
	public Task saveTask(Task task);
	
	public Task getTask(int id);
	
	public List<Task> getAllTasks();
	
	public boolean deleteTask(Task task);
	
	public List<Task> sortTasks(Comparator<Task> comparator);
	
	public List<Task> getAllTasks(Comparator<Task> comparator);
	
}
