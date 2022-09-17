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
        int data=temp.val;
        
        
        while(temp.next!=null){
            data=temp.val;
            if(temp.next.val!=data){
                temp=temp.next;
            }
            else{
                temp.next=temp.next.next;
            }
        }
        return head;
    }
}