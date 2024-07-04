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
    public ListNode mergeNodes(ListNode head) {
        int sum =0;
        ListNode headCopy = head;
        ListNode traversal = head.next;
        ListNode lastZero = head;

        while(traversal.next != null){
            if(traversal.val == 0){
                lastZero.val = sum;
                lastZero.next = traversal;
                lastZero = lastZero.next;
                sum = 0;
            }
            else{
                sum += traversal.val;
            }
            traversal = traversal.next;
        }

        lastZero.val = sum;
        lastZero.next = null;

        return headCopy;
    }
}