/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode recursive(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val==p.val || root.val==q.val) return root;
        
        TreeNode left=recursive(root.left, p, q);
        TreeNode right=recursive(root.right, p, q);
        if(left!=null && right!=null) return root;
        else if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        return null;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursive(root, p, q);
        
    }
}