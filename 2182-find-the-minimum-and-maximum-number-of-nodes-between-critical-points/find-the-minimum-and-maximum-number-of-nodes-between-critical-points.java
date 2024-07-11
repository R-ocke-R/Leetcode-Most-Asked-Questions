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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next == null && head.next.next == null) return new int[]{-1, -1};

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = head.next.next;

        int count =1;
        int firstM = -1;
        int lastM = 100000;
        int minDistance = 100000;
        int finalM = -1;
        int points = 0;

        while(three != null){
            // check if maxima 
            if(one.val < two.val && two.val > three.val){
                if(points == 0) firstM = count; 
                else lastM = Math.min(lastM, count - finalM );
                //lastM = count;
                finalM = count;
                points ++;

            }
            // check if minima
            if(one.val > two.val && two.val < three.val){
                if(points == 0) firstM = count; 
                else lastM = Math.min(lastM, count - finalM );
                finalM = count;
                points ++;
            }

            count ++;
            one = two;
            two = three;
            three = three.next;
        }
        
        if(points < 2) return new int[]{-1, -1};

        return new int[]{lastM, finalM - firstM};




    }
}