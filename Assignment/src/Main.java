public class Main {

	public static void main(String[] args) {
		EmployeesList list = new EmployeesList();
		int choose = 0;
		int type = 0;
		String choose1 = "";
		do {
			choose = Menu.menu(choose);
			switch (choose) {
				case 1:
					do {
						type = Menu.menuType(type);
						list.inputEmployees(type);
						System.out.print("Do you want to continue (Y/N): ");
						choose1 = ExceptionData.yesOrNo();
					} while (!choose1.equalsIgnoreCase("N"));
					break;
				case 2:
					list.displayList();
					break;
				case 3:
					list.highestSalary();
					break;
				case 4:
					list.searchEmployees();
					break;
				case 5:
					System.out.println("Goodbye !!");
					break;
				default:
					System.out.print("Wrong enter, please choose again !!");
					break;
			}
		} while (choose != 5);
	}
}
