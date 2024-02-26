package edu.jsp.taskmanager.model;

import java.time.LocalDate;
import java.util.Objects;

public class Task {

	private int id;
	private String name;
	private LocalDate startDate;
	private LocalDate DeadLine;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getDeadLine() {
		return DeadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		DeadLine = deadLine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task() {
		super();
	}

	public Task(int id, String name, LocalDate startDate, LocalDate deadLine, String description) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.DeadLine = deadLine;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DeadLine, description, id, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}
	
	

}

