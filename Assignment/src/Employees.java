import java.util.Objects;

public class Employees implements Comparable<Employees> {
	protected String iD;
	protected String name;
	protected String phoneNumber;
	protected String email;
	protected double salary;
	private double totalSalary;

	public Employees(String iD, String name, String phoneNumber, String email, double salary) {
		super();
		this.iD = iD;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.salary = salary;
	}

	public Employees() {
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "Employees [iD=" + iD + ", name=" + name + ", phoneNumber = " + phoneNumber + ", email=" + email
				+ ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalSalary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Double.doubleToLongBits(totalSalary) == Double.doubleToLongBits(other.totalSalary);
	}

	@Override
	public int compareTo(Employees o) {
		return this.name.compareTo(o.name);
	}
}
