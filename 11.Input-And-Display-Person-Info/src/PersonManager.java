import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonManager {
	ArrayList<Person> personList = new ArrayList<>();

	public PersonManager() {
	}

	public PersonManager(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public void addInformationPerson(Person person) {
		personList.add(person);
	}

	public ArrayList<Person> sortSalaryAscending() {
		if (personList.isEmpty()) {
			System.out.println("List is empty!!");
		} else {
			Collections.sort(this.personList, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					if (o1.getSalary() > o2.getSalary()) {
						return 1;
					} else if (o1.getSalary() < o2.getSalary()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		return personList;
	}

}
