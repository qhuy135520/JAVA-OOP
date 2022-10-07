import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
	PersonManager personManager = new PersonManager();
	List<String> choices = Arrays.asList("\t\t\tMENU", "===============Management Person programer==============",
			"1. Input person information", "2. Show 3 persons information by ascending of salary", "3. Exit",
			"===============Management Person programer==============", "Choose: ");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public int inputInformationPerson() {

		int count = 0;
		System.out.println("========================================================");
		while (true) {
			Person person = new Person();
			System.out.print("Please input name:  ");
			person.setName(ExceptionData.inputName());

			System.out.print("Please input address: ");
			person.setAddress(ExceptionData.inputString());

			System.out.print("Please input salary: ");
			person.setSalary(ExceptionData.inputPositiveFloat());
			count++;
			personManager.addInformationPerson(person);
			if (ExceptionData.yesOrNo().equalsIgnoreCase("N")) {
				break;
			}

		}
		return count;
	}

	public void displayRecentlyInformation() {
		int count = inputInformationPerson();
		ArrayList<Person> temp = personManager.personList;
		for (int i = temp.size() - count; i < temp.size(); i++) {
			System.out.println("========================================================");
			System.out.println("Information of Person you have entered:");
			System.out.print("Name: " + temp.get(i).getName() + "\n");
			System.out.print("Address: " + temp.get(i).getAddress() + "\n");
			System.out.print("Salary: " + temp.get(i).getSalary() + "\n");
		}
	}

	public void displayAcesdingSalary() {
		ArrayList<Person> temp = personManager.sortSalaryAscending();
		int count = 0;
		System.out.println("==================Ascending Of Salary===================");
		System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Salary");
		for (Person person : temp) {
			if (count == 3) {
				break;
			} else {
				System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getSalary());
				count++;
			}
		}
	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				displayRecentlyInformation();
				break;
			case 2:
				displayAcesdingSalary();
			case 3:
				System.out.println("Good Bye!!");
				System.exit(0);
			}
		}
	}
}
