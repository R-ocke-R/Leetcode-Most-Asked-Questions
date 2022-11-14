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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        while(l1!=null) {
            s1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> s2=new Stack<>();
        while(l2!=null) {
            s2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode newHead=null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int n=s1.isEmpty() ? 0: s1.pop();
            int n2=s2.isEmpty() ? 0: s2.pop();
            
            int temp=n+n2+carry;
            
            ListNode newNode = new ListNode(temp%10);
            newNode.next=newHead;
            newHead=newNode;
            carry=temp/10;
        }
        return newHead;
    }
}

/*
Continuing from add two numbers LC 2 
Nothing really changed except that now the numbers aren't in reverse order 
so the pointers might not be at the same ten's place in the starting (head) of LL's

approach 1 

reverse the LL's and make this question same as LC 2

make the new LL and at the front in a way you don't need to reverse.


approach 2 with added space complexity

use a stack to have data in reverse order
*/
