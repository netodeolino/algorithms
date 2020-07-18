public class LoopDetection {

    public static boolean loopDetection(LinkedListNode linkedList) {
        Node slow = null;
        Node fast = null;

        if (linkedList != null && linkedList.head != null) {
            slow = linkedList.head;
            fast = linkedList.head;
        }

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // same object
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();

        Node node = new Node(5);

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(10);
        list.insertFirstNode(node);
        list.insertFirst(8);
        list.insertFirst(5);

        System.out.println(loopDetection(list)); // false

        list.insertFirstNode(node);

        System.out.println(loopDetection(list)); // true
    }
}