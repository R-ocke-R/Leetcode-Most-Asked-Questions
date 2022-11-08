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
    public TreeNode merger(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return null;
        
        // simplest would be to make a new node and use tertiary operator to add ? root1.val : 0 if null
        // but don't need to make new nodes and waste space can utilize either root1 or root2's nodes as primary.
        
        if(root1!=null && root2==null) return root1; // no need to call for any of the child nodes, 
        if(root1==null && root2!=null) return root2;
        
        // when both not null;
        
        root1.val+=root2.val;
        root1.left=merger(root1.left, root2.left);
        root1.right=merger(root1.right, root2.right);
        return root1;
        
        
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merger(root1, root2);
    }
}