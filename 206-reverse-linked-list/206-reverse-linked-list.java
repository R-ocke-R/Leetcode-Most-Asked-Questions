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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=head;
        ListNode temp=null;
        ListNode front=head.next;
        while(front.next!=null){
            temp=front.next;
            front.next=prev;
            prev=front;
            front=temp;
        }
        front.next=prev;
        head.next=null;
        head=front;
        return head;
    }
}