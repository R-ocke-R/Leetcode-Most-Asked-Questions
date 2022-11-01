//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class pair{
        Node nod;
        int line;
        pair(Node temp, int line){
            this.nod=temp;
            this.line=line;
        }
    }
    
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<pair> queue= new LinkedList<>();
        
        int leftLine=0;
        
        Map<Integer, ArrayList<Integer>> map= new TreeMap<>();
        
        queue.add(new pair(root, 0));
        
        while(!queue.isEmpty()){
            pair temp=queue.remove();
            // add to map based on its temp's line.
            if(!map.containsKey(temp.line)){
                map.put(temp.line, new ArrayList<Integer>());
            }
            map.get(temp.line).add(temp.nod.data);
            
            //update left line
            leftLine=Math.min(leftLine, temp.line);
            
            if(temp.nod.left!=null) queue.add(new pair(temp.nod.left, temp.line-1));
            if(temp.nod.right!=null) queue.add(new pair(temp.nod.right, temp.line+1));
            
            
        }
        // System.out.println(Arrays.asList(map));
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
            // System.out.println(
            //     "[" + entry.getKey()
            //     + ", " + entry.getValue() + "]");
        
        return ans;
        
    }
}