import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeesList {
	private ArrayList<Employees> list = new ArrayList<>();

	public void inputEmployees(int type) {

		System.out.print("Enter ID: ");
		String iD = ExceptionData.inputString();

		System.out.print("Enter name: ");
		String name = ExceptionData.inputName();

		System.out.print("Enter phone number: ");
		String phone = ExceptionData.inputPhoneNumber();

		System.out.print("Enter email: ");
		String email = ExceptionData.inputEmail();

		System.out.print("Enter coefficients salary: ");
		double salary = ExceptionData.inputDouble();

		switch (type) {
		case 1:
			System.out.print("Enter level: ");
			int level = ExceptionData.inputInt();

			System.out.print("Enter major: ");
			String major = ExceptionData.inputString();

			System.out.print("Enter position allowance: ");
			int position = ExceptionData.inputInt();

			Employees doctor = new Doctor(iD, name, phone, email, salary, level, major, position);
			list.add(doctor);
			break;
		case 2:
			System.out.print("Enter department: ");
			String department = ExceptionData.inputString();

			System.out.print("Enter overtime hours: ");
			int hours = ExceptionData.inputInt();

			Employees nurse = new Nurse(iD, name, phone, email, salary, department, hours);
			list.add(nurse);
			break;
		}
	}

	public void displayList() {
		int countDoctor = 0;
		int countNurse = 0;
		if (list.isEmpty()) {
			System.out.println("List is empty !!");
		} else {
			System.out.println("||=============================DOCTOR=============================||");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).toString().contains("Doctor")) {
					System.out.println(list.get(i).toString());
					countDoctor++;
				}
			}
			if (countDoctor == 0) {
				System.out.println("DOCTOR: Empty List !!!");
			}
			System.out.println("||=============================NURSE==============================||");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).toString().contains("Nurse")) {
					System.out.println(list.get(i).toString());
					countNurse++;
				}
			}
			if (countNurse == 0) {
				System.out.println("NURSE: Empty List !!!");
			}
			System.out.println("||================================================================||");
		}
	}

	public void highestSalary() {
		if (!list.isEmpty()) {
			Collections.sort(this.list, new Comparator<Employees>() {
				@Override
				public int compare(Employees o1, Employees o2) {
					if (o1.getTotalSalary() < o2.getTotalSalary()) {
						return 1;
					} else if (o1.getTotalSalary() > o2.getTotalSalary()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			System.out.println("Employees information has the highest total salary: ");
			System.out.println(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getTotalSalary() == list.get(0).getTotalSalary()) {
					System.out.println(list.get(i));
				}
			}
		} else {
			System.out.println("List is empty !!");
		}
	}

	public void searchEmployees() {
		if (!list.isEmpty()) {
			System.out.print("Enter name: ");
			String inputName = ExceptionData.inputName();
			inputName = inputName.trim();
			System.out.println("1. Doctor");
			System.out.println("2. Nurse");
			System.out.print("Enter type: ");
			int choice = ExceptionData.inputChoice();
			int count = 0;
			switch (choice) {
			case 1:

				for (Employees Doctor : list) {
					if (Doctor.getName().indexOf(inputName) >= 0 && Doctor.toString().contains("Doctor")) {
						System.out.println(Doctor);
						count++;
					}
				}
				if (count++ == 0) {
					System.out.println("Not Found");
				}
				break;
			case 2:
				for (Employees Nurse : list) {
					if (Nurse.getName().indexOf(inputName) >= 0 && Nurse.toString().contains("Nurse")) {
						System.out.println(Nurse);
						count++;
					}
				}
				if (count++ == 0) {
					System.out.println("Not Found");
				}
				break;
			}
		}else {
			System.out.println("List is empty!!");
		}
	}
}
