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
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        ListNode travel = head;
        int count = 0;
        while(travel!= null){
            travel = travel.next;
            count++;
        }

        count -= n;
        travel = dummy;
        while(count>0){
            travel = travel.next;
            count--;
        }
        travel.next=travel.next.next;


        return dummy.next;

    }
}