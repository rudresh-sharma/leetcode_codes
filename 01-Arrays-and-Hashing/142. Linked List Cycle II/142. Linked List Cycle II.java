1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        ListNode slow = head, fast = head;
4        while (fast != null && fast.next != null) {
5            slow = slow.next;
6            fast = fast.next.next;
7            if (slow == fast) break;
8        }
9        if (fast == null || fast.next == null) return null;
10        while (head != slow) {
11            head = head.next;
12            slow = slow.next;
13        }
14        return head;
15    }
16}