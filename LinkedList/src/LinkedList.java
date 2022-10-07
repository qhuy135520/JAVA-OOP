public class LinkedList {
	Node head, tail;

	public LinkedList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		Node p = head;
		int c = 0;
		while (p != null) {
			c++;
			p = p.next;
		}
		return c;
	}

	// Add to Head
	public void addHead(int x) {
		Node p = new Node(x);
		if (isEmpty()) {
			head = tail = p;
		} else {
			p.next = head;
			head = p;
		}
	}

	// Add to Tail
	public void addTail(int x) {
		Node p = new Node(x);
		if (isEmpty()) {
			head = tail = p;
		} else {
			tail.next = p;
			tail = p;
		}
	}
	
	void addAfter(Node q, int x) {
		if (isEmpty() || q == null) {
			return;
		}

		Node q1 = q.next;
		Node p = new Node(x, q1);
		q.next = p;

		if (tail == q) {
			tail = p;
		}
	}

	// Traversal
	public void traversal() {
		Node p = head;
		while (p != null) {
			System.out.print(p.info + "  ");
			p = p.next;
		}
		System.out.println("");
	}

	// deleFirst
	public void deleFirst() {
		if (isEmpty()) {
			return;
		}

		head = head.next;

		if (head == null) {
			tail = null;
		}
	}

	// delete tail
	static Node removeLastNode(Node head) {
		if (head == null)
			return null;

		if (head.next == null) {
			return null;
		}

		Node second_last = head;
		while (second_last.next.next != null)
			second_last = second_last.next;

		second_last.next = null;

		return head;
	}

	// delete after
	public void deleAfter(Node q) {
		if (isEmpty() || q == null) {
			return;
		}

		if (q == head) {
			deleFirst();
			return;
		}

		Node f = head;

		while (f != null && f.next != q) {
			f = f.next;
		}

		if (f == null) {
			return;
		}
		Node q1 = q.next;
		f.next = q1;
		if (f.next == null) {
			tail = f;
		}
	}

	public Node get(int k) {
		Node p = head;
		int c = 0;
		while (p != null && c < k) {
			c++;
			p = p.next;
		}
		return p;
	}

	public Node search(int x) {
		Node p = head;
		while (p != null && p.info != x)
			p = p.next;
		return p;
	}
}
