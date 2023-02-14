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
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode chotaHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return chotaHead;
    }
    public void print(ListNode head){
        
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=slow;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow);
        slow=head;
        print(slow);
        while(fast!=null) {
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}