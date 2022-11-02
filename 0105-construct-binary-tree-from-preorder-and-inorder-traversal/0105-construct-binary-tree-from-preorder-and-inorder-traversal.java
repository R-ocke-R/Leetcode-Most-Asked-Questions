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
    int preIndex;
    public int finder(int[] inorder, int element){
        for(int i=0;i<inorder.length;i++){
            if(element==inorder[i]) return i;
        }
        return -1;
    }
    public TreeNode builder(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int length){
        
        if(preIndex>=length || inorderStart>inorderEnd) return null;
        
        int element=preorder[preIndex++];
        int rootInInorder=finder(inorder, element);
        
        TreeNode temp= new TreeNode(element);
        temp.left=builder(preorder, inorder, inorderStart, rootInInorder-1, length);
        temp.right=builder(preorder, inorder, rootInInorder+1, inorderEnd, length);
        
        return temp;       
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        int n=preorder.length;
        return builder(preorder, inorder, 0, n-1, n);
    }
}