public class Partition {

    public static LinkedListNode mergeLinkedList(LinkedListNode one, LinkedListNode two) {
        LinkedListNode newList = new LinkedListNode();

        while (one.head != null) {
            newList.appendToTail(one.head.data);
            one.head = one.head.next;
        }

        while (two.head != null) {
            newList.appendToTail(two.head.data);
            two.head = two.head.next;
        }

        return newList;
    }

    public static LinkedListNode partition(LinkedListNode linkedList, int x) {
        LinkedListNode left = new LinkedListNode();
        LinkedListNode right = new LinkedListNode();

        Node node = null;

        if (linkedList != null && linkedList.head != null) {
            node = linkedList.head;
        }

        while (node != null) {
            if (node.data < x) {
                left.insertFirst(node.data);
            } else {
                right.insertFirst(node.data);
            }
            node = node.next;
        }

        return mergeLinkedList(left, right);
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(10);
        list.insertFirst(5);
        list.insertFirst(8);
        list.insertFirst(5);
        list.insertFirst(3);

        list = partition(list, 5);

        list.print();
    }
}