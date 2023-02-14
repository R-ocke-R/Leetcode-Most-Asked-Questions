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
    public int counter(ListNode head){
        int count=0;
        while(head!=null) {
            head=head.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // this will be a recursive function that reverses k nodes at a time
        
        if(head==null ) return head;
        
        if(counter(head)<k) return head;
        
        // we have k nodes to be reversed
        ListNode prev=null;
        ListNode curr= head;
        ListNode forw=null;
        
        int count=0;
        
        while(count!=k){
            count++;
            
            forw=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=forw;
            
        }
        
        // K nodes reversed
        head.next=reverseKGroup(forw, k);
        
        return prev;
    }
}