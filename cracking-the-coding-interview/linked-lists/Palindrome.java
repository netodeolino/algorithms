public class Palindrome {

    public static LinkedListNode reverse(LinkedListNode linkedList) {
        LinkedListNode reversed = new LinkedListNode();
        
        Node node = null;

        if (linkedList != null && linkedList.head != null) {
            node = linkedList.head;
        }

        while (node != null) {
            reversed.insertFirst(node.data);
            node = node.next;
        }

        return reversed;
    }

    public static boolean isEqual(LinkedListNode linkedListOne, LinkedListNode linkedListTwo) {
        Node one = null;
        Node two = null;

        if (linkedListOne != null && linkedListOne.head != null) {
            one = linkedListOne.head;
        }

        if (linkedListTwo != null && linkedListTwo.head != null) {
            two = linkedListTwo.head;
        }

        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    public static boolean palindrome(LinkedListNode linkedList) {
        LinkedListNode reversed = reverse(linkedList);
        return isEqual(linkedList, reversed);
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

        System.out.println(palindrome(list));

        LinkedListNode list2 = new LinkedListNode();

        list2.insertFirst(0);
        list2.insertFirst(1);
        list2.insertFirst(2);
        list2.insertFirst(1);
        list2.insertFirst(0);

        System.out.println(palindrome(list2));
    }
}