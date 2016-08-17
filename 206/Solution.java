public class Solution {

    public ListNode reverseList(ListNode head) {
        if ((head == null) || (head.next == null)) return head;
        ListNode prev = null, curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }

    private static ListNode construct(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = construct(new int[] {1, 2});
        System.out.println(head.toString());
        System.out.println(new Solution().reverseList(head).toString());
    }
}
