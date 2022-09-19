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
    public ListNode deleteDuplicates(ListNode head) {
                
        if(head==null || head.next==null) return head;
        
        ListNode temp=head;
        
        while(temp.next!=null) {
            if(temp.next.val==temp.val)
                temp.next=temp.next.next;
            else
                temp=temp.next;
        }
        
        return head;
        
    }
}