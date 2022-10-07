import java.util.Scanner;

public class ConsoleForm {
	public void execute() {
		System.out.print("Phone number: ");
		String phone = ExceptionData.inputPhoneNumber();
		System.out.print("Date: ");
		String date = ExceptionData.inputDate();
		System.out.print("Email: ");
		String email = ExceptionData.inputEmail();
		System.out.println("successful!");
	}
}
