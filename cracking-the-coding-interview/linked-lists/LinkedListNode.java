public class LinkedListNode {
	Node head;

	public LinkedListNode() {
		this.head = null;
	}

	public void insertFirst(int d) {
		if (this.head == null) {
			this.head = new Node(d);
		} else {
			Node end = this.head;
			this.head = new Node(d);
			this.head.next = end;
		}
	}

	public void insertFirstNode(Node node) {
		if (this.head == null) {
			this.head = node;
		} else {
			Node end = this.head;
			this.head = node;
			this.head.next = end;
		}
	}

	public void appendToTail(int d) {
		Node n = this.head;
		Node end = new Node(d);
		
		if (n == null) {
			this.head = end;
		} else {
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}

	public Node deleteNode(int d) {
		Node n = this.head;

		if (n == null) {
			return null;
		}

		if (n.data == d) {
			return this.head.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return this.head;
			}
			n = n.next;
		}

		return this.head;
	}

	public void print() {
		Node n = this.head;
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}