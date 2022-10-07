import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class ConsoleForm {
	TaskManage tm = new TaskManage();
	List<String> choices = Arrays.asList("||======== Task Program ========||", "||1. Add Task                   ||",
			"||2. Delete Task                ||", "||3. Display Task               ||",
			"||4. Exit                       ||", "||==============================||");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public void addTask() {
		while (true) {
			Task task = new Task();
			System.out.println("------------Add Task---------------");

			System.out.print("Requirement Name: ");
			task.setRequirementName(ExceptionData.inputName());

			System.out.print("Task Type: ");
			task.setiD(ExceptionData.inputID());
			task.setTaskTypeID(ExceptionData.taskType(task.getiD()));

			System.out.print("Date: ");
			task.setDate(ExceptionData.inputDate());

			System.out.print("From: ");
			task.setPlanFrom(ExceptionData.inputPlanFrom());

			System.out.print("To: ");
			task.setPlanTo(ExceptionData.inputPlanTo(task.getPlanFrom()));

			System.out.print("Assignee: ");
			task.setAssignee(ExceptionData.inputString());

			System.out.print("Reviewer: ");
			task.setExpert(ExceptionData.inputName());

			tm.addTask(task);
			System.out.println("Susccessful!!");
			if (ExceptionData.yesOrNo().equalsIgnoreCase("n")) {
				break;
			}
		}
	}

	public void deleteTask() {

		System.out.println("---------Del Task---------");
		System.out.print("ID: ");
		int iD = ExceptionData.inputPositiveInt();

		if (!tm.task.isEmpty()) {
			boolean isExist = tm.deleteTask(iD);
			if (!isExist) {
				System.out.println("Not found!!");
			} else {
				System.out.println("Successful!!");
			}
		} else {
			System.out.println("Empty List!!");
		}
	}

	public void showTask() {
		if (!tm.task.isEmpty()) {
			System.out.printf("%-10s%-15s%-20s%-20s%-15s%-20s%-20s\n", "ID", "Name", "Task Type", "Date", "Time",
					"Assignee", "Reviewer");
			for (Task t : tm.task) {
				System.out.printf("%-10d%-15s%-20s%-20s%-15.1f%-20s%-20s\n", t.getiD(), t.getRequirementName(),
						t.getTaskTypeID(), t.getDate(), (t.getPlanTo() - t.getPlanFrom()), t.getAssignee(),
						t.getExpert());
			}
		} else {
			System.out.println("List is Empty !!");
		}
	}

	public void execute() {

		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				addTask();
				break;
			case 2:
				deleteTask();
				break;
			case 3:
				showTask();
				break;
			case 4:
				System.out.println("Good Bye !!");
				System.exit(0);
			}
		}
	}
}
