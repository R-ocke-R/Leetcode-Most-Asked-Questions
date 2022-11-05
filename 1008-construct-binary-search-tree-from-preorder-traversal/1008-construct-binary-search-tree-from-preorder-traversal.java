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
        return helper(preorder, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preorder, int end){
        if(nodeIndex==preorder.length || preorder[nodeIndex]>end){
            return null;
        }
        int val=preorder[nodeIndex++];
        TreeNode node=new TreeNode(val);
        node.left=helper(preorder, val);
        if(nodeIndex!=preorder.length  &&  preorder[nodeIndex]>val) node.right=helper(preorder, end);
        return node;
    }
}