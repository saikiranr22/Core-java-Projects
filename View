package edu.jsp.taskmanager.view;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import edu.jsp.taskmanager.controller.Controller;
import edu.jsp.taskmanager.model.SortByDeadLine;
import edu.jsp.taskmanager.model.SortById;
import edu.jsp.taskmanager.model.SortByName;
import edu.jsp.taskmanager.model.SortByStartDate;
import edu.jsp.taskmanager.model.Task;
import edu.jsp.taskmanager.model.exception.TaskNotFoundException;

public class View {

	private Controller controller;
	private Scanner scanner;

	private void saveTask() {

		System.out.println("Enter Task id : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Task Name : ");
		String name = scanner.nextLine();

		System.out.println("Enter Task Starting Date in (YYYY-MM-DD) Format : ");
		String date = scanner.nextLine();
		LocalDate localDate = LocalDate.parse(date);

		System.out.println("Enter Task DeadLine in (YYYY-MM-DD) Format : ");
		String end = scanner.nextLine();
		LocalDate deadLine = LocalDate.parse(end);

		System.out.println("Enter Task Description : ");
		String description = scanner.nextLine();

		Task task = new Task(id, name, localDate, deadLine, description);

		if (controller.saveTask(task) != null) {
			System.out.println("Task Saved Successfully");
		} else {
			System.out.println("Something went wrong Task not saved");
		}
	}

	private void searchTask() {

		System.out.println("Enter Task id : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {

			Task task = controller.getTask(id);
			displayTask(task);

		} catch (TaskNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void displayTask(Task task) {
		System.out.println("------------------------------------------");
		System.out.println("Task Id : " + task.getId());
		System.out.println("Task Name : " + task.getName());
		System.out.println("Task Starting Date : " + task.getStartDate());
		System.out.println("Task DeadLine : " + task.getDeadLine());
		System.out.println("Task Description : " + task.getDescription());
		System.out.println("------------------------------------------");
	}

	private void deleteTask() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter Task Name : ");
			String name = scanner.nextLine();

			System.out.println("Enter Task Starting Date in (YYYY-MM-DD) Format : ");
			String date = scanner.nextLine();
			LocalDate localDate = LocalDate.parse(date);

			System.out.println("Enter Task DeadLine in (YYYY-MM-DD) Format : ");
			String end = scanner.nextLine();
			LocalDate deadLine = LocalDate.parse(end);

			System.out.println("Enter Task Description : ");
			String description = scanner.nextLine();

			Task task = new Task(id, name, localDate, deadLine, description);

			if (controller.deleteTask(task)) {
				System.out.println("Task Deleted");
			} else {
				System.out.println("Task Not Deleted");
			}
		} else {
			System.out.println("No Tasks Found");
		}

	}

	private void displayAlltasks(List<Task> tasks) {

		if (tasks != null && !tasks.isEmpty()) {

			for (Task task : tasks) {
				displayTask(task);
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void sortTask() {
		System.out.println("ENTER SORTING OPTION\n" + "1. BY ID\n" + "2. BY NAME\n" + "3.BY START DATE\n"
				+ "4.BY DEADLINE\n" + "5.DON'T SORT");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1: {
			displayAlltasks(controller.getAllTasks(new SortById()));
			break;
		}
		case 2: {
			displayAlltasks(controller.getAllTasks(new SortByName()));
			break;

		}
		case 3: {
			displayAlltasks(controller.getAllTasks(new SortByStartDate()));
			break;

		}
		case 4: {
			displayAlltasks(controller.getAllTasks(new SortByDeadLine()));
			break;

		}
		case 5: {
			displayAlltasks(controller.getAllTasks());
			break;
		}
		default: {
			System.out.println("INVALID CHOICE");
		}
			break;
		}
	}

	private void updateName() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			try {
				Task task = controller.getTask(id);

				System.out.println("Enter Task Name : ");
				String name = scanner.nextLine();

				task.setName(name);

				System.out.println("Task Name Updated");

				displayTask(task);

			} catch (TaskNotFoundException exception) {
				System.out.println(exception.getMessage());
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void updateStartDate() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			try {
				Task task = controller.getTask(id);

				System.out.println("Enter Task Start Date : ");
				LocalDate date = LocalDate.parse(scanner.nextLine());

				task.setStartDate(date);

				System.out.println("Task Start Date Updated");

				displayTask(task);

			} catch (TaskNotFoundException exception) {
				System.out.println(exception.getMessage());
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void updateAll() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			try {
				Task task = controller.getTask(id);

				System.out.println("Enter Task Name : ");
				String name = scanner.nextLine();

				System.out.println("Enter Task Starting Date in (YYYY-MM-DD) Format : ");
				String date = scanner.nextLine();
				LocalDate localDate = LocalDate.parse(date);

				System.out.println("Enter Task DeadLine in (YYYY-MM-DD) Format : ");
				String end = scanner.nextLine();
				LocalDate deadLine = LocalDate.parse(end);

				System.out.println("Enter Task Description : ");
				String description = scanner.nextLine();

				task.setName(name);
				task.setStartDate(localDate);
				task.setDeadLine(deadLine);
				task.setDescription(description);

				System.out.println("Task Details Updated");

				displayTask(task);

			} catch (TaskNotFoundException exception) {
				System.out.println(exception.getMessage());
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void updateDeadLine() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			try {
				Task task = controller.getTask(id);

				System.out.println("Enter Task DeadLine : ");
				LocalDate date = LocalDate.parse(scanner.nextLine());

				task.setDeadLine(date);

				System.out.println("Task DeadLine Updated");

				displayTask(task);

			} catch (TaskNotFoundException exception) {
				System.out.println(exception.getMessage());
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void updateDescription() {

		List<Task> tasks = controller.getAllTasks();

		if (tasks != null && !tasks.isEmpty()) {

			System.out.println("Enter Task id : ");
			int id = scanner.nextInt();
			scanner.nextLine();

			try {
				Task task = controller.getTask(id);

				System.out.println("Enter Task Description : ");
				String description = scanner.nextLine();

				task.setDescription(description);

				System.out.println("Task Description Updated");

				displayTask(task);

			} catch (TaskNotFoundException exception) {
				System.out.println(exception.getMessage());
			}

		} else {
			System.out.println("No Tasks Found");
		}
	}

	private void update() {
		System.out.println("ENTER UPDATE OPTION\n" + "1.UPDATE NAME\n" + "2.UPDATE START DATE\n" + "3.UPDATE DEADLINE\n"
				+ "4.UPDATE DESCRIPTION\n" + "5.UPDATE ALL\n" + "6.DONT UPADTE\n");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1: {
			updateName();
			break;
		}
		case 2: {
			updateStartDate();
			break;
		}
		case 3: {
			updateDeadLine();
			break;
		}
		case 4: {
			updateDescription();
			break;
		}
		case 5: {
			updateAll();
			break;
		}
		case 6: {
			break;
		}

		default: {
			System.out.println("INVALID CHOICE PLEASE TRY AGAIN");
		}
			break;
		}
	}

	private void start() {

		int exit;

		do {
			System.out.println("-------------------------SELECT OPERATION TO PERFORM-----------------------------\n"
					+ "1.SEARCH TASK\n" + "2.GET ALL TASKS\n" + "3.SAVE TASK\n" + "4.DELETE TASK\n" + "5.UPDATE\n"
					+ "6.EXIT");

			int choice = scanner.nextInt();
			scanner.nextLine();
			exit = choice;

			switch (choice) {
			case 1: {
				searchTask();
				break;
			}
			case 2: {
				sortTask();
				break;
			}
			case 3: {
				saveTask();
				break;
			}
			case 4: {
				deleteTask();
				break;
			}

			case 5: {
				update();
				break;
			}
			case 6: {
				System.out.println("THANK YOU...");
				break;
			}

			default:
				System.out.println("INVALID CHOICE PLEASE TRY AGAIN");
				break;
			}
		} while (exit != 6);
	}

	public View(Controller controller, Scanner scanner) {
		this.controller = controller;
		this.scanner = scanner;
	}

	public static void main(String[] args) {

		View view = new View(new Controller(), new Scanner(System.in));
		view.start();
	}

}
