import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleForm {
	List<String> choices = Arrays.asList("||==============File Processing ==============||",
			"||1. Check Path                               ||", "||2. Get file name with type java             ||",
			"||3. Get file with size greater than input    ||", "||4. Write more content to file               ||",
			"||5. Read file and count characters           ||", "||6. Exit                                     ||",
			"||============================================||", "Please choice one option: ");

	public int getChoice() {
		choices.forEach(c -> System.out.println(c));
		return ExceptionData.inputLimit();
	}

	private static void checkPath() {
		System.out.print("Enter path: ");
		String path = ExceptionData.inputString();
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			System.out.println("Path to File.");
		} else if (file.exists() && file.isDirectory()) {
			System.out.println("Path to Directory");
		} else {
			System.out.println("Path doesn't exist");
		}
	}

	private static void getAllFileNameJavaInDirectory() {
		ArrayList<String> listFileName = new ArrayList<>();
		System.out.print("Enter path: ");
		String path = ExceptionData.inputString();
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			File[] listFile = file.listFiles();
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isFile() && listFile[i].getName().endsWith(".java")) {
					listFileName.add(listFile[i].getName());
				}
			}
		} else {
			System.out.println("Path doesn't exist");
			return;
		}
		System.out.println("Result " + listFileName.size() + " file!");
		for (int i = 0; i < listFileName.size(); i++) {
			System.out.println(listFileName.get(i));
		}
	}

	private static void getFileWithSizeGreaterThanInput() {
		System.out.print("Enter size: ");
		int size = ExceptionData.inputInt();
		System.out.print("Enter path: ");
		String path = ExceptionData.inputString();

		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			File[] listFile = file.listFiles();
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isFile() && listFile[i].length() > size) {
					System.out.println(listFile[i].getName());
				}
			}
		} else {
			System.out.println("Path doesn't exist");
			return;
		}
	}

	private static void appendContentToFile() throws IOException {
		System.out.print("Enter content: ");
		String content = ExceptionData.inputString();
		System.out.print("Enter path: ");
		String path = ExceptionData.inputString();
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.append(content);
			writer.close();
			System.out.println("Write done");
		} else {
			System.out.println("Path doesn't exist");
		}
	}

	private static void countCharacter() throws FileNotFoundException, IOException {
		System.out.print("Enter path: ");
		String path = ExceptionData.inputString();
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();
			int count = 0;
			while (line != null) {
				String[] parts = line.split(" ");
				for (String w : parts) {
					count++;
				}
				line = reader.readLine();
			}
			System.out.println("Total: " + count);
		} else {
			System.out.println("Path doesn't exist");
		}
	}

	public void execute() throws IOException {
		while (true) {
			int choice = getChoice();
			switch (choice) {
			case 1:
				checkPath();
				break;
			case 2:
				getAllFileNameJavaInDirectory();
				break;
			case 3:
				getFileWithSizeGreaterThanInput();
				break;
			case 4:
				appendContentToFile();
				break;
			case 5:
				countCharacter();
				break;
			case 6:
				System.out.println("GoodBye!!");
				System.exit(0);
			}
		}
	}
}
