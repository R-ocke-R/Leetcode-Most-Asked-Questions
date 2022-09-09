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
    public int cnt(ListNode temp) {
        int counter=0;
        while(temp!=null) {
            temp=temp.next;
            counter++;
        }
        return counter;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null ) return head;
        
        //step 2:
        ListNode prev= null;
        ListNode curr= head;
        ListNode front= null;
        
        int count=0;
        if(cnt(head)<k) return head;
        while( curr!=null && count < k){
            
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;            
            count++;
            
        }
        //step 3:
        
        if(front != null ) head.next=reverseKGroup(front, k);
        
        return prev;
        
        
    }
}