package edu.jsp.taskmanager.model;

import java.util.Comparator;

public class SortByDeadLine implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		return o1.getDeadLine().compareTo(o2.getDeadLine());

	}

}
