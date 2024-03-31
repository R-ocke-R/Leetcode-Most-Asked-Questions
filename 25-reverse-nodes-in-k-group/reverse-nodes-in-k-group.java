class Solution {
    // class pair{
    //     ListNode one;
    //     ListNode two;
    //     pair(ListNode one, ListNode two){
    //         this.one = one;
    //         this.two = two;
    //     }
    // }
    public int counter(ListNode head){
        int count=0;
        while(head!=null) {
            head=head.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroupIterative(ListNode head, int k){

        int counter = counter(head);
        int loopCount = counter / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        while(loopCount -- != 0){
            ListNode prev = null;
            ListNode curr = pointer.next;
            ListNode next = null;
            int count = k; 
            while(count-- != 0){
                next = curr.next;
                curr.next = prev;
                prev = curr; 
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
            }
        return dummy.next;

    }
    public ListNode reverseKGroup(ListNode head, int k){
        // driver function.
        return reverseKGroupIterative(head, k);
    }
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
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