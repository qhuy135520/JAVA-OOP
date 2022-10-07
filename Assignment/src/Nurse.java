public class Nurse extends Employees {
	protected String department;
	protected int hours;
	protected double totalSalary = (this.salary * 1650000) + this.hours * 200000;;

	public Nurse(String iD, String name, String phoneNumber, String email, double salary, String department,
			int hours) {
		super(iD, name, phoneNumber, email, salary);
		this.department = department;
		this.hours = hours;
	}

	public String getDepartment() {
		return department;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Nurse ID = " + iD + " || Name = " + name + " || Email " + email + " || Phone Number = 0" + phoneNumber
				+ " || Salary = " + totalSalary + " || Department = " + department + " || Over time hours = " + hours;
	}
}
