import java.util.Arrays;
import java.util.List;

public class ConsoleForm {

	Manager manager = new Manager();
	List<String> choices = Arrays.asList("\t\t\tMENU", "===============Dictionary Program==============",
			"1. Add new word", "2. Delete word", "3. Search word", "4. Exit",
			"===============Management Person programer==============", "Choose: ");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public void execute() {
		Manager m = new Manager();

		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				m.addNewWord();
				break;
			case 2:
				m.deleteWord();
				break;
			case 3:
				m.translate();
				break;
			case 4:
				System.out.println("Good Bye!!");
				System.exit(0);
			}
		}
	}
}
