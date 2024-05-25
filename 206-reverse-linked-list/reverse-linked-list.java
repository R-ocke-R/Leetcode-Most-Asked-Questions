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
    public ListNode recursive(ListNode head){

        return head;


    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null) return head;
        ListNode badaHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return badaHead;
    }
}