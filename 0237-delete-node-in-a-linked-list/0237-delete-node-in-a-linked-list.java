/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // a little wierd input
        // I think the only "approach" could be to push data values to one step forward 
        //which technically is delete a value not delete a node
        while(node.next.next!=null){
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
    // Approch 2 could also be delete a value, but simpler
    // node.val=node.next.val;
    // node.next=node.next.next;
}