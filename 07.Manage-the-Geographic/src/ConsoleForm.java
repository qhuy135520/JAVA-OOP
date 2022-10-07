import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleForm {
	ManageEastAsiaCountries manageEastAsiaCountries = new ManageEastAsiaCountries();
	List<String> choices = Arrays.asList("\t\t\tMENU",
			"==========================================================================",
			"1. Input the information of countries in East Asia",
			"2. Display the information of country you've just input",
			"3. Search the information of country by user-entered name",
			"4. Display the information of countries sorted name in ascending order", "5. Exit ",
			"==========================================================================");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	public void inputCountry() {
		while (true) {
			EastAsiaCountries eastAsiaCountries = new EastAsiaCountries();

			System.out.println("Enter code of country: ");
			eastAsiaCountries
					.setCountryCode(ExceptionData.inputCode(manageEastAsiaCountries.eastAsiaCountriesArrayList));
			System.out.println("Enter name of country:");
			eastAsiaCountries.setCountryName(ExceptionData.inputString());
			System.out.println("Enter total Area:");
			eastAsiaCountries.setTotalArea(ExceptionData.inputPositiveDouble());
			System.out.println("Enter terrain of country:");
			eastAsiaCountries.setCountryTerrain(ExceptionData.inputString());

			manageEastAsiaCountries.addCountryInformation(eastAsiaCountries);
			if (ExceptionData.yesOrNo().equalsIgnoreCase("N")) {
				break;
			}
		}
	}

	public void displayRecently() {
		EastAsiaCountries temp = manageEastAsiaCountries.getRecentlyEnteredInformation();
		System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
		System.out.printf("%-20s%-20s%-20.1f%-20s\n", temp.getCountryCode(), temp.getCountryName(), temp.getTotalArea(),
				temp.getCountryTerrain());
	}

	public void displaySearch() {
		System.out.println("Enter the name you want to search for: ");
		String name = ExceptionData.inputString();
		ArrayList<EastAsiaCountries> result = manageEastAsiaCountries.searchInformationByName(name);
		if (!result.isEmpty()) {
			System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
			for (EastAsiaCountries e : result) {
				System.out.printf("%-20s%-20s%-20.1f%-20s\n", e.getCountryCode(), e.getCountryName(), e.getTotalArea(),
						e.getCountryTerrain());
			}
		} else {
			System.out.println("Not found");
		}
	}

	public void sortNameCountry() {
		ArrayList<EastAsiaCountries> temp = manageEastAsiaCountries.sortInformationByAscendingOrder();
		System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
		for (EastAsiaCountries e : temp) {
			System.out.printf("%-20s%-20s%-20.1f%-20s\n", e.getCountryCode(), e.getCountryName(), e.getTotalArea(),
					e.getCountryTerrain());
		}
	}

	public void execute() {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				inputCountry();
				break;
			case 2:
				displayRecently();
				break;
			case 3:
				displaySearch();
				break;
			case 4:
				sortNameCountry();
				break;
			case 5:
				System.out.println("Good bye!!");
				System.exit(0);
			}
		}
	}

}
