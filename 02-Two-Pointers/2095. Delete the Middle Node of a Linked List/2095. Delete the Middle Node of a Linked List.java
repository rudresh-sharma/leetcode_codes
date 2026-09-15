1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13
14        if(head.next == null){
15            head=null;
16            return head;
17        }
18        ListNode slow = head, fast =  head.next.next;
19        while(fast != null && fast.next!=null){
20            
21            slow = slow.next;
22            fast = fast.next.next;
23        } 
24
25        //  System.out.println(prv.val);
26        slow.next = slow.next.next;
27       
28        return head;
29    }
30}