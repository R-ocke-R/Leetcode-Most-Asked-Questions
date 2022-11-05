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
    public void inorder(ArrayList<Integer> path, TreeNode root){
        if(root==null) return ;
        inorder(path, root.left);
        path.add(root.val);
        inorder(path, root.right);
    }
    int index;
    public TreeNode balanceTree( ArrayList<Integer> path, int start, int end){
        if(start>end) return null;
        
        int mid=start+(end-start)/2;
        
        TreeNode temp= new TreeNode(path.get(mid));
        
        temp.left= balanceTree(path, start, mid-1);
        temp.right=balanceTree(path, mid+1, end);
        
        return temp;
        
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        inorder(path, root);
        index=0;
        return balanceTree(path, 0, path.size()-1);
        
    }
}