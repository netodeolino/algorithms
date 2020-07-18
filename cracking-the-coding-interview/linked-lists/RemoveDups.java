public class RemoveDups {

	public static void removeDups(LinkedListNode linkedList) {
		Node current = linkedList.head;
		
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode();

		list.appendToTail(15);
		list.appendToTail(10);
		list.appendToTail(7);
		list.appendToTail(10);

		removeDups(list);

		list.print();
	}
}