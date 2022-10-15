//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // From love babber Placement series, 
        //approach one would be todata replacement
        //coding second : pointers change O(1) space, O(n) time
        if(head.next==null) return head;
        Node z=new Node(-1);
        Node zeros=z;
        Node o=new Node(-1);
        Node ones=o;
        Node t=new Node(-1);
        Node twos=t;
        
        while(head!=null){
            if(head.data==0){
                zeros.next=head;
                zeros=zeros.next;
            }
            if(head.data==1){
                ones.next=head;
                ones=ones.next;
            }
            if(head.data==2){
                twos.next=head;
                twos=twos.next;
            }
            head=head.next;
        }
        if(o.next!=null){
            zeros.next=o.next;
        }
        else{
            zeros.next=t.next;
        }
        ones.next=t.next;
        twos.next=null;
        
        return z.next;
    }
}


