/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count and remove (total - n + 1) from front.
        ListNode dummy = new ListNode (0, head);

        ListNode end = dummy;
        while(n!=0){
            end = end.next;
            n--;
        }
        ListNode front = dummy;

        while( end.next != null){
            end = end.next;
            front = front.next;
        }
        front.next = front.next.next;
        return dummy.next;
    }
}