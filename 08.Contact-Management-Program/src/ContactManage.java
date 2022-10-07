import java.util.ArrayList;
import java.util.Collections;

public class ContactManage {
	ArrayList<Contact> contactList = new ArrayList<>();

	public ContactManage() {
	}

	public ContactManage(ArrayList<Contact> ContactList) {
		this.contactList = ContactList;
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<Contact> contactList) {
		this.contactList = contactList;
	}

	public void addContactInformation(Contact contact) {
		contactList.add(contact);
	}


	public static void deleteContact(ArrayList<Contact> contact, int idDelete) {

		Contact contactDelete = getIdContact(contact, idDelete);
		if (contactDelete == null) {
			System.err.println("Not found contact.");
			return;
		} else {
			contact.remove(contactDelete);
		}
		System.err.println("Successful.");
	}

	public static Contact getIdContact(ArrayList<Contact> contact, int idDelete) {
		for (Contact c : contact) {
			if (c.getiD() == idDelete) {
				return c;
			}
		}
		return null;
	}
}
