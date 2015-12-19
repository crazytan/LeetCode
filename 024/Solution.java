import java.util.*;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            if (next != null)
                return val + " -> " + next.toString();
            else
                return val + "";
        }
    }

    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) return head;
        ListNode _head = new ListNode(0);
        ListNode curr = _head;
        _head.next = head;
        while ((curr.next != null) && (curr.next.next != null)) {
            ListNode a = curr.next;
            ListNode b = curr.next.next;
            ListNode c = curr.next.next.next;
            curr.next = b;
            b.next = a;
            a.next = c;
            curr = a;
        }
        return _head.next;
    }

    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(swapPairs(b));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}