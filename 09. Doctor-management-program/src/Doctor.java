import java.util.Objects;

public class Doctor {
	private String code;
	private String name;
	private String Specialization;
	private int availability;

	public Doctor() {
	}

	public Doctor(String code, String name, String Specialization, int availability) {
		this.code = code;
		this.name = name;
		this.Specialization = Specialization;
		this.availability = availability;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String obstetrics) {
		this.Specialization = obstetrics;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Specialization, availability, code, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(Specialization, other.Specialization) && availability == other.availability
				&& Objects.equals(code, other.code) && Objects.equals(name, other.name);
	}

}
