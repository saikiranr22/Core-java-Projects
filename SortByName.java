package edu.jsp.taskmanager.model;

import java.util.Comparator;

public class SortByName implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
