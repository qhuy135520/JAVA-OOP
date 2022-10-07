import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
	public static int count = 0;
	ContactManage contactManage = new ContactManage();
	List<String> choices = Arrays.asList("====== Contact program ======", "||=========================||",
			"||1. Add a contact         ||", "||2. Display all contact   ||", "||3. Delete a contact      ||",
			"||4. Exit                  ||", "||=========================||");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));// print menu
		System.out.print("Enter your choose: ");
		return ExceptionData.inputLimit();// get choice from keyboard
	}

	public void inputInformation() {
		while (true) {
			Contact contact = new Contact();
			count++;
			contact.setiD(count);
			System.out.println("-------- Add a Contact --------");
			System.out.print("Enter First Name: ");
			contact.setFirtName(ExceptionData.inputName());

			System.out.print("Enter Last Name: ");
			contact.setLastName(ExceptionData.inputName());

			System.out.print("Enter Group: ");
			contact.setGroup(ExceptionData.inputString());

			System.out.print("Enter Address: ");
			contact.setAddress(ExceptionData.inputString());

			System.out.print("Enter phone: ");
			contact.setPhoneNumber(ExceptionData.inputPhoneNumber());

			contactManage.addContactInformation(contact);
			System.err.println("Successful");
			if (ExceptionData.yesOrNo().equalsIgnoreCase("N"))
				break;
		}
	}

	public void displayAll() {
		ArrayList<Contact> temp = contactManage.contactList;
		if (!temp.isEmpty()) {
			System.out.println(
					"------------------------------------- Display all Contact --------------------------------");
			System.out.printf("%-5s%-15s%-20s%-15s%-10s%-15s%-10s\n", "ID", "Name", "First Name", "Last Name", "Group",
					"Address", "Phone");
			for (Contact e : temp) {
				System.out.printf("%-5d%-15s%-20s%-15s%-10s%-15s%-10s\n", e.getiD(),
						e.getFirtName() + " " + e.getLastName(), e.getFirtName(), e.getLastName(), e.getGroup(),
						e.getAddress(), e.getPhoneNumber());
			}
		} else {
			System.err.println("List is empty!!");
		}
	}

	public void removeContact() {
		System.out.println("------- Delete a Contact -------");
		int idDelete = ExceptionData.inputId();
		ContactManage.deleteContact(contactManage.contactList, idDelete);
	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				inputInformation();
				break;
			case 2:
				displayAll();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				System.out.println("Good bye !!! ");
				System.exit(0);
			}
		}
	}
}
