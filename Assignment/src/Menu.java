import java.util.Scanner;

public class Menu {
	public static int menu(int choose) {
		Scanner sc = new Scanner(System.in);
		System.out.println("||================MANAGE EMPLOYEES IN HOSPITAL====================||");
		System.out.println("|| 1. Create                                                      ||");
		System.out.println("|| 2. View all employees information                              ||");
		System.out.println("|| 3. View the employees information has the highest total salary ||");
		System.out.println("|| 4. Searching                                                   ||");
		System.out.println("|| 5. Exit                                                        ||");
		System.out.println("||================================================================||");
		System.out.print("Enter your choose: ");
		choose = ExceptionData.inputInt();
		return choose;
	}
	public static int menuType(int type) {
		System.out.println("Type:");
		System.out.println("1. Doctor");
		System.out.println("2. Nurse");
		System.out.print("Please enter type: ");
		return type = ExceptionData.inputChoice();
	}
}
