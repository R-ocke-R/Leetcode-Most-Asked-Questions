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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val) return merger(list1, list2);
        return merger(list2, list1);
    }
    public ListNode merger(ListNode first, ListNode second){
        // this function's sole job is to merge the "nodes" of second list in order between nodes of first
        ListNode prev=first;
        ListNode curr=first.next;
        while(curr!=null && second!=null){
            if(curr.val>=second.val){
                prev.next=second;
                second=second.next;
                prev=prev.next;
                prev.next=curr;
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        if(curr==null && second != null) prev.next=second;
        return first;
    }
}