class MinStack {
    private Node head;
    private class Node{
        int data;
        int min;
        Node next;
        private Node(int data, int min, Node next){
            this.data=data;
            this.min=min;
            this.next=next;
        }
    }
    public MinStack() {// Two array is also a thing, but then I would have to make the array dynamic by doubling and stuff.
        head=null;        
    }
    
    public void push(int val) {
        if(head==null) head=new Node(val, val, null);
        else head=new Node(val, Math.min(val, head.min), head);
    }
    
    public void pop() {
        head=head.next;        
    }
    
    public int top() {
        return head.data;        
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */