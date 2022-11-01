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
    int nodeIndex;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null ) return null;
        
        nodeIndex=0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder, int start, int end){
        if(nodeIndex==preorder.length || preorder[nodeIndex]< start || preorder[nodeIndex]>end){
            return null;
        }
        int val=preorder[nodeIndex++];
        TreeNode node=new TreeNode(val);
        node.left=helper(preorder, start, val);
        node.right=helper(preorder, val, end);
        return node;
    }
}