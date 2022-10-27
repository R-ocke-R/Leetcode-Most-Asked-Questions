/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Stack<ArrayList<Integer>> reversal= new Stack<ArrayList<Integer>>();
        ArrayList<Integer> dummy = new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()){
            // System.out.println("hi");
            TreeNode temp= queue.remove();
            
            if(temp==null){                
                reversal.push(dummy);
                dummy=new ArrayList<Integer>();    
                if(queue.isEmpty()) break;
                queue.add(null);
            }
            else{
                dummy.add(temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
        }
        // System.out.println(reversal);
        while(!reversal.isEmpty()) {
            ans.add(reversal.pop());
        }
        return ans;
        
    }
}