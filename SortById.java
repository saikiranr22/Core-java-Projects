package edu.jsp.taskmanager.model;

import java.util.Comparator;

public class SortById implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		return o1.getId() - o2.getId();
	}

}
