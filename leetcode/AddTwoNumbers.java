class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void insertFirst(int val) {
		if (this.next == null) {
			this.next = new ListNode(val);
		} else {
			ListNode end = this.next;
			this.next = new ListNode(val);
			this.next.next = end;
		}
	}

    public void print() {
		ListNode n = this.next;
		
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
}

class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode cur = out;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry > 0) {
            
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            cur.next = new ListNode(sum);
            
            cur = cur.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return out.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.insertFirst(3);
        l1.insertFirst(4);
        l1.insertFirst(2);

        ListNode l2 = new ListNode();
        l2.insertFirst(4);
        l2.insertFirst(6);
        l2.insertFirst(5);

        ListNode l3 = addTwoNumbers(l1, l2);
        l3.print();
    }
}
