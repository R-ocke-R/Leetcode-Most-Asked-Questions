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
    // root to leaf paths. -> preorder will do
    public void recursive(TreeNode root, int targetSum, ArrayList<Integer> path, List<List<Integer>> ans){
        if(root==null) return ;
        
        path.add(root.val);
        targetSum-=root.val;
        // System.out.println(path);
        if(root.left==null && root.right==null) {
            // found a root to leaf path in path list
            if(targetSum==0) {
                // add the path formed into ans
                ans.add(new ArrayList<Integer>(path));
                // path is mutable
            }            
        }
        
        recursive(root.left, targetSum, path, ans);
        recursive(root.right, targetSum, path, ans);
        
        path.remove(path.size()-1);
        return;
                
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        
        recursive(root, targetSum, path, ans);
        return ans;
    }
}