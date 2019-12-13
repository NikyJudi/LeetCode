
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (cur1 != null || cur2 != null) {
            int x = (cur1 != null) ? cur1.val : 0;
            int y = (cur2 != null) ? cur2.val : 0;
            int sum = flag + x + y;
            node.next = new ListNode(sum % 10 );
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            node = node.next;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (flag > 0) {
            node.next = new ListNode(flag);
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        l1.next = n1;
        n1.next = n2;
        l2.next = n3;
        n3.next = n4;
        ListNode cur= addTwoNumbers(l1, l2);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
