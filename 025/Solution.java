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

    private boolean hasKNext(ListNode head, int k) {
        while (k > 0) {
            head = head.next;
            if (head == null) return false;
            k--;
        }
        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if ((head == null) || (head.next == null) || (k <= 1)) return head;
        ListNode _head = new ListNode(0);
        ListNode curr = _head;
        _head.next = head;
        while (hasKNext(curr, k)) {
            ListNode prev = curr;
            ListNode _curr = curr.next;
            ListNode next = _curr;
            for (int i = 0;i < k;i++) {
                next = _curr.next;
                _curr.next = prev;
                prev = _curr;
                _curr = next;
            }
            curr.next.next = next;
            _curr = curr.next;
            curr.next = prev;
            curr = _curr;
        }
        return _head.next;
    }

    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(reverseKGroup(a, 1));
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}