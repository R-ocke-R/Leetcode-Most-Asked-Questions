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
        // code to reverse the later half of the list. uses recursive appraoch
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
        // USED two pointer to get to the middle of the list, using no extra space.
        // reversed the later half
        fast=reverse(slow);
        slow=head;
        print(slow);
        // now simply camparing the two different halfes.
        while(fast!=null) {
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}

// Note the last pointer of the first half still holds a link to its next node which is part of the other half. but this "bug" is helpful when the length of the list is odd.