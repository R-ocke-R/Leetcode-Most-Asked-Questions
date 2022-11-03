//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static Node targetAndMapping(Node root, int target, Map<Node, Node> mapping){
        Node res=null;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        mapping.put(root, null);
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            
            if(temp.data==target) res=temp;
            
            if(temp.left!=null){
                mapping.put(temp.left, temp);
                queue.add(temp.left);
            }        
            if(temp.right!=null){
                mapping.put(temp.right, temp);
                queue.add(temp.right);
            }
            
        }
        return res;
        
    }
    public static int burnTree(Node burning, Map<Node, Node> mapping){
        int flag=0;
        int time=0;
        
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited= new HashMap<>();
        
        visited.put(burning, true);
        queue.add(burning);
        
        while(!queue.isEmpty()){
            
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                Node temp=queue.remove();
                // burn its adjacent
                if(temp.left!=null && !visited.containsKey(temp.left)){
                    visited.put(temp.left, true);
                    queue.add(temp.left);
                    flag=1;
                }
                if(temp.right!=null && !visited.containsKey(temp.right)){
                    visited.put(temp.right, true);
                    queue.add(temp.right);
                    flag=1;
                }
                if(mapping.get(temp)!=null && !visited.containsKey(mapping.get(temp))){
                    visited.put(mapping.get(temp), true);
                    queue.add(mapping.get(temp));
                    flag=1;
                }
            }
            if(flag==1){
                flag=0;
                time++;
            }
        }
        return time;
        
    }
    public static int minTime(Node root, int target) 
    {
        // Algorithm:
        // create a mapping from parent to child
        //find the target node
        // burn the fucking tree
        Map<Node, Node> mapping=new HashMap<>();
        Node burning=targetAndMapping(root, target, mapping);
        
        return burnTree(burning, mapping);
        
    }
}