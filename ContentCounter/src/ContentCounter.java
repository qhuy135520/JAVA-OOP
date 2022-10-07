import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ContentCounter {

	private Map<Character, Integer> charCount = new HashMap<Character, Integer>();

	private Map<String, Integer> wordCount = new HashMap<String, Integer>();

	public void display() {
		System.out.println(wordCount);
		System.out.println(charCount);
	}

	public void contentCount(String content) {
		for (char ch : content.toCharArray()) {
			if (Character.isSpaceChar(ch))
				continue;
			if (!charCount.containsKey(ch)) {
				charCount.put(ch, 1);
			} else {
				charCount.put(ch, ((int) charCount.get(ch)) + 1);
			}
		}
		StringTokenizer tokenizer = new StringTokenizer(content);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (!wordCount.containsKey(token)) {
				wordCount.put(token, 1);
			} else {
				wordCount.put(token, ((int) wordCount.get(token)) + 1);
			}
		}
	}
}