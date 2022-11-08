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
    
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        int val=helper(root);
        return max;
        // return Math.max(val, max);
    }
    
    
    int max=0;
    
    int helper(TreeNode root){
        if(root==null) return 0;
        
        // now as we discussed the max can also be formed by 
        // only leftPath + root.val || or || rightPath+root.val
        // coz maybe right || or || left respectively in those cases might have a path that has its sum -> negative.
        
        int left=Math.max(helper(root.left), 0);
        int right=Math.max(helper(root.right), 0);
        
        // we calculate the max for the given root node with which the function is called currently, 
        // the max can be in the 1)left subtree or the 2) right subtree exclusive of the root value.
        // could be rightsubtreeSum+root.val or leftSubtreeSum+root.val or the whole path left+right+path; 
        // all of the cases are solved by this single math.max line(42)
        max=Math.max(max, root.val+left+right);
        
        
        // now after we know the max why is there a need to return anything. This is the optimization part, we return the 
        // maxPath  possible (downwards direction or simple root to leaf path) for the nodes above the root node in the heirarchy
        // so that they may calculate their line->42 Max.
        
        return root.val+Math.max(left, right);
    }
}