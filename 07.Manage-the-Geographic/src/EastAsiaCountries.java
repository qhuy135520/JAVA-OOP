public class EastAsiaCountries extends Country {
	private String countryTerrain;

	public EastAsiaCountries() {
	}

	public EastAsiaCountries(String countryCode, String countryName, double totalArea, String countryTerrain) {
		super(countryCode, countryName, totalArea);
		this.countryTerrain = countryTerrain;
	}

	public String getCountryTerrain() {
		return countryTerrain;
	}

	public void setCountryTerrain(String countryTerrain) {
		this.countryTerrain = countryTerrain;
	}
}
