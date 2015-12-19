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

    public ListNode mergeKLists(ListNode[] lists) {
        if ((lists == null) || (lists.length <= 0)) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 0;i < lists.length;i++) {
            if (lists[i] != null) heap.add(lists[i]);
        }
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            curr.next = tmp;
            curr = tmp;
            if (tmp.next != null) {
                heap.add(tmp.next);
            }
        }
        return head.next;
    }

    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = c;
        b.next = d;
        ListNode tmp = mergeKLists(new ListNode[] {a, b});
        System.out.println(tmp);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}