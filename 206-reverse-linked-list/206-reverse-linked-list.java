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
    // public ListNode reverseList(ListNode head) {
    //     if(head==null || head.next==null) return head;
    //     ListNode prev=head;
    //     ListNode temp=null;
    //     ListNode front=head.next;
    //     while(front.next!=null){
    //         temp=front.next;
    //         front.next=prev;
    //         prev=front;
    //         front=temp;
    //     }
    //     front.next=prev;
    //     head.next=null;
    //     head=front;
    //     return head;
    // }
//     public ListNode reverseList(ListNode head) {
//         if(head==null || head.next==null ) return head;
//         ListNode temp= head;
//         ListNode prev=null;
//         ListNode front=head.next;
//         while(front != null){
            
//             temp.next=prev;
            
//             prev=temp;
//             temp=front;
//             front=front.next;
            
//         }
//         temp.next=prev;
//         // head=temp;
//         // return head;
//         return temp;
//     }
    
    // moving from iterative to recursive approaches
    public ListNode reverseList(ListNode head){
        
        //base cases
        if(head==null|| head.next==null) return head;
        // now we know that reverseList function is supposed to return the reverse of the list and pointer to its head
        ListNode chotaHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        
        
        
        return chotaHead;
    }
    
    
    
    
}