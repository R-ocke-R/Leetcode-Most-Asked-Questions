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
    public int deepestLeavesSum(TreeNode root) {          
        
        if(root==null) return -1;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        int last=0;
        while(!queue.isEmpty())
        {
            TreeNode temp= queue.remove();
            
            if(temp==null) {
                
                if(queue.isEmpty()) return last;
                queue.add(null);
                last=0;
                continue;
            }
            
            last+=temp.val;
            
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        return last;
    }
}