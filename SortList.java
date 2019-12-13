class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class SortList {
    //在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) {
            cur.next = right;
        } else {
            cur.next = left;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode Node1 = new ListNode(2);
        ListNode Node2 = new ListNode(1);
        ListNode Node3 = new ListNode(3);
        head.next = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = null;
        ListNode newH = sortList(head);
    }
}
