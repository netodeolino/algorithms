public class ReturnKthToLast {

    public static int returnKthToLast(LinkedListNode linkedList, int k) {
        Node n1 = linkedList.head;
        Node n2 = linkedList.head;

        for (int i = 0; i < k; i++) {
            if (n1 == null) {
                return -1;
            }
            n1 = n1.next;
        }

        while (n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2.data;
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();

        list.insertFirst(9);
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(7);

        System.out.println(returnKthToLast(list, 1));
        System.out.println(returnKthToLast(list, 3));
    }
}