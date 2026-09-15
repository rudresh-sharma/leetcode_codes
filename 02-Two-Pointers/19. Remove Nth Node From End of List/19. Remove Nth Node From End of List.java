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
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        ListNode pointer = head;
14        int size = 0;
15
16        if(head == null || head.next == null) return null;
17
18
19        while(pointer != null){
20            pointer = pointer.next;
21            size++;
22        }
23
24        int node = size-n;
25    if(node == 0){
26            head = head.next;
27            return head;
28        }
29        pointer = head;
30
31        for(int i=0; i<node-1&&pointer.next!=null; i++){
32            pointer = pointer.next;
33        }
34
35        ListNode remove = pointer.next;
36        if(pointer != null && remove != null)
37        pointer.next = remove.next;
38
39        return head;
40
41
42
43    }
44}