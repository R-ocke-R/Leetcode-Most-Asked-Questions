class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < k; i++){
            p2 = p2.next;
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = head;
        ListNode newHead = p1.next;
        p1.next = null;
        return newHead;
    }
}