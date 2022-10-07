import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Manager {
	HashMap<String, String> list = new HashMap<String, String>();

	public Manager() {
	}

	public Manager(HashMap<String, String> list) {
		this.list = list;
	}

	public HashMap<String, String> getList() {
		return list;
	}

	public void setList(HashMap<String, String> list) {
		this.list = list;
	}

	public void addNewWord() {
		System.out.print("Enter Enlish: ");
		String english = ExceptionData.inputString();
		if (!checkKeywordExist(english)) {
			System.err.println("Exit word!!");
			translate(english);
			if (ExceptionData.yesOrNo().equalsIgnoreCase("n")) {
				return;
			}
		}
		System.out.print("Enter Vietnamese: ");
		String vietnam = ExceptionData.inputString();
		list.put(english, vietnam);
		System.err.println("Add successful.");
	}

	public void deleteWord() {
		System.out.print("Enter english: ");
		String english = ExceptionData.inputString();
		list.remove(english);
		System.err.println("Delete successful.");
	}

	public void translate() {
		System.out.print("Enter english: ");
		String english = ExceptionData.inputString();
		Set<Map.Entry<String, String>> entries = list.entrySet();
		for (Map.Entry entry : entries) {
			if (entry.getKey().equals(english)) {
				System.out.println("Vietnamese: " + entry.getValue());
				return;
			}
		}
		System.err.println("Not found in data");
	}

	public void translate(String english) {
		Set<Map.Entry<String, String>> entries = list.entrySet();
		for (Map.Entry entry : entries) {
			if (entry.getKey().equals(english)) {
				System.err.println("It is: Vietnamese: " + entry.getValue());
				return;
			}
		}
	}

	public boolean checkKeywordExist(String english) {
		Set set = list.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			if (english.equalsIgnoreCase(mentry.getKey().toString())) {
				return false;
			}
		}
		return true;
	}
}
