import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your content: ");
		String content = scanner.nextLine();
		ContentCounter count = new ContentCounter();
		count.contentCount(content);
		count.display();
	}
}
