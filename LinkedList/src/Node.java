public class Node {

	int info;
	Node next;

	Node(int info, Node next) {
		this.info = info;
		this.next = next;
	}

	Node(int info) {
		this(info, null);
	}
}