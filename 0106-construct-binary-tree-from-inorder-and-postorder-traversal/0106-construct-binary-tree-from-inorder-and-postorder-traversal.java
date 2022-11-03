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
    int postIndex;
    public TreeNode builder(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int length, Map<Integer, Integer> mapping){
        
        if(postIndex<0 || inorderStart>inorderEnd) return null;
        
        int element=postorder[postIndex--];
        int rootInInorder=mapping.get(element);
        
        TreeNode temp= new TreeNode(element);
        temp.right=builder(inorder, postorder, rootInInorder+1, inorderEnd, length, mapping);
        temp.left=builder(inorder, postorder, inorderStart, rootInInorder-1, length, mapping);        
        return temp;       
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        postIndex=n-1;
        Map<Integer, Integer> mapping= new HashMap<>();
        for(int i=0;i<n;i++){
            mapping.put(inorder[i], i);
        }
        return builder(inorder, postorder, 0, n-1, n, mapping);
    }
}