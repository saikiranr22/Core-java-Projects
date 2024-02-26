Task Manager Application

The Task Manager Application is a Java-based project designed to facilitate task management operations such as creating, retrieving, updating, and deleting tasks. Built using Object-Oriented Programming (OOP) principles and leveraging Java's collection framework, this application provides a robust and efficient solution for organizing tasks.

Features
Task Management: Easily create, retrieve, update, and delete tasks.
Sorting: Sort tasks based on various criteria such as ID, start date, deadline, and name.
Exception Handling: Custom exceptions like TaskNotFoundException enhance error handling.
Usage
Prerequisites
Java Development Kit (JDK) installed on your system.
Maven installed on your system (optional but recommended).
Getting Started
Clone this repository to your local machine.
bash

//Copy code
git clone https://github.com/saikiranr22/task-manager.git
Navigate to the project directory.
bash

//Copy code
cd task-manager
Running the Application
You can utilize the Task Manager application in your own projects by following these steps:

Import the project into your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
Use the provided classes (Task, Controller, SortById, etc.) in your application as needed.
Ensure that the required dependencies are included in your project's build path or Maven pom.xml file, such as junit for testing and java.time for date handling.
Customize the application according to your specific requirements, extending its functionality or integrating it into your existing systems.
Example Usage
Here's an example demonstrating how to utilize the Task Manager application in your Java project:

java
Copy code
import edu.jsp.taskmanager.model.Task;
import edu.jsp.taskmanager.controller.Controller;

public class Main {
    public static void main(String[] args) {
        // Create a new task
        Task task1 = new Task(1, "Task 1", LocalDate.now(), LocalDate.now().plusDays(7), "Description of Task 1");

        // Instantiate the controller
        Controller controller = new Controller();

        // Save the task
        controller.saveTask(task1);

        // Retrieve the task by ID
        Task retrievedTask = controller.getTask(1);

        // Print the retrieved task
        System.out.println("Retrieved Task: " + retrievedTask);
    }
}
Contributor
Saikiran Reddy
License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it as per the terms of the license.

Acknowledgments
Special thanks to contributors and open-source libraries used in this project.
