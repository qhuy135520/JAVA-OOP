
public class Doctor extends Employees {
	protected int level;
	protected String major;
	protected int position;
	protected double totalSalary = ((this.level + this.salary) * 1650000) + this.position;;

	public Doctor(String iD, String name, String phoneNumber, String email, double salary, int level, String major,
			int position) {
		super(iD, name, phoneNumber, email, salary);
		this.level = level;
		this.major = major;
		this.position = position;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "Doctor ID = " + iD + " || Name = " + name + " || Email " + email + " || Phone number = " + phoneNumber
				+ " || Total Salary = " + totalSalary + " || level = " + level + " || major = " + major
				+ " || position = "
				+ position;
	}

}
