public class DeleteMiddleNode {

    public static void deleteMiddleNode(LinkedListNode linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();

        list.insertFirst(9);
        list.insertFirst(43);
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(7);
        list.insertFirst(81);
        list.insertFirst(2);

        list.print();

        deleteMiddleNode(list);

        System.out.println("");
        System.out.println("----------------");

        list.print();
    }
}