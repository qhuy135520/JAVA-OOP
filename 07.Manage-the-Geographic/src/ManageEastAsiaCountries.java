import java.util.ArrayList;
import java.util.Collections;

public class ManageEastAsiaCountries {
	ArrayList<EastAsiaCountries> eastAsiaCountriesArrayList = new ArrayList<>();

	public ManageEastAsiaCountries() {
	}

	public ManageEastAsiaCountries(ArrayList<EastAsiaCountries> eastAsiaCountriesArrayList) {
		this.eastAsiaCountriesArrayList = eastAsiaCountriesArrayList;
	}

	public ArrayList<EastAsiaCountries> getEastAsiaCountriesArrayList() {
		return eastAsiaCountriesArrayList;
	}

	public void setEastAsiaCountriesArrayList(ArrayList<EastAsiaCountries> eastAsiaCountriesArrayList) {
		this.eastAsiaCountriesArrayList = eastAsiaCountriesArrayList;
	}

	public void addCountryInformation(EastAsiaCountries country) {
		eastAsiaCountriesArrayList.add(country);
	}

	public EastAsiaCountries getRecentlyEnteredInformation() {
		if (eastAsiaCountriesArrayList.size() > 0) {
			return eastAsiaCountriesArrayList.get(eastAsiaCountriesArrayList.size() - 1);
		}
		return null;
	}

	public ArrayList<EastAsiaCountries> searchInformationByName(String name) {
		name = name.toLowerCase();
		ArrayList<EastAsiaCountries> result = new ArrayList<>();
		for (EastAsiaCountries e : eastAsiaCountriesArrayList) {
			if (e.getCountryName().toLowerCase().contains(name)) {
				result.add(e);
			}
		}
		return result;
	}

	public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() {
		ArrayList<EastAsiaCountries> result = eastAsiaCountriesArrayList;
		Collections.sort(result, (c1, c2) -> {
			return c1.getCountryName().compareTo(c2.getCountryName());
		});
		return result;
	}
}
