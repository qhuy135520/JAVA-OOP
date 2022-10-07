import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
	DoctorManage doctorManage = new DoctorManage();
	List<String> choices = Arrays.asList("====== Contact program ======", "||=========================||",
			"||1. Add Doctor            ||", "||2. Update Doctor         ||", "||3. Delete a contact      ||",
			"||4. View All Doctor       ||", "||5. Exit                  ||", "||=========================||");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));// print menu
		System.out.print("Enter your choose: ");
		return ExceptionData.inputLimit();// get choice from keyboard
	}

	public void inputInformation() {
		while (true) {
			Doctor doctor = new Doctor();
			System.out.println("-------- Add Doctor --------");
			System.out.print("Enter Code: ");

			doctor.setCode(ExceptionData.inputCode(doctorManage.doctorList));

			System.out.print("Enter Name: ");
			doctor.setName(ExceptionData.inputName());

			System.out.print("Enter Specialization: ");
			doctor.setSpecialization(ExceptionData.inputString());

			System.out.print("Enter Availability:: ");
			doctor.setAvailability(ExceptionData.inputPositiveInt());

			doctorManage.addDoctor(doctor);
			System.err.println("Successful");
			if (ExceptionData.yesOrNo().equalsIgnoreCase("N"))
				break;
		}
	}

	public void displayAll() {
		ArrayList<Doctor> temp = doctorManage.doctorList;
		if (!temp.isEmpty()) {
			System.out.println(
					"------------------------------------- Display all Contact --------------------------------");
			System.out.printf("%-10s%-15s%-20s%-15s\n", "Code", "Name", "Specialization", "Availability");
			for (Doctor d : temp) {
				System.out.printf("%-10s%-15s%-20s%-20d\n", d.getCode(), d.getName(), d.getSpecialization(),
						d.getAvailability());
			}
		} else {
			System.err.println("List is empty!!");
		}
	}

	public void removeContact() {
		System.out.println("------- Delete a Contact -------");
		System.out.print("Enter code: ");
		String codeDelete = ExceptionData.inputString();
		doctorManage.deleteContact(doctorManage.doctorList, codeDelete);
	}

	public void updateDoctor() {
		System.out.print("Enter code: ");
		String code = ExceptionData.inputString();
		if (!ExceptionData.updateCode(doctorManage.doctorList, code)) {
			System.err.println("Not found, changed failed !!");
			return;
		}

		Doctor dr = DoctorManage.getCodeDoctor(doctorManage.doctorList, code);
		System.out.print("Enter code: ");
		String codeUpdate = ExceptionData.changeCode(dr, doctorManage.doctorList);
		System.out.print("Enter name: ");
		String nameUpdate = ExceptionData.inputName();
		System.out.print("Enter specialization: ");
		String specializationUpdate = ExceptionData.inputName();
		System.out.print("Enter availability: ");
		int availabilityUpdate = ExceptionData.inputPositiveInt();

		if (!ExceptionData.checkChange(dr, codeUpdate, nameUpdate, specializationUpdate, availabilityUpdate)) {
			System.err.println("Nothing changed");
			return;
		}
		dr.setCode(codeUpdate);
		dr.setName(nameUpdate);
		dr.setSpecialization(specializationUpdate);
		dr.setAvailability(availabilityUpdate);
		System.err.println("Update successful");
	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				inputInformation();
				break;
			case 2:
				updateDoctor();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				displayAll();
				break;
			case 5:
				System.out.println("Good bye !!! ");
				System.exit(0);
			}
		}
	}
}
