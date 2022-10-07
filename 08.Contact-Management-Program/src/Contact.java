
public class Contact {
	private int iD;
	private String firstName;
	private String lastName;
	private String group;
	private String address;
	private String phoneNumber;

	public Contact() {
	}

	public Contact(int count, int iD, String firstName, String lastName, String group, String address,
			String phoneNumber) {
		this.iD = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = group;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getFirtName() {
		return firstName;
	}

	public void setFirtName(String firtName) {
		this.firstName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
