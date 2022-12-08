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
    public void toleaf(TreeNode root1, ArrayList<Integer> ans){
        if(root1==null) return ;

        // had to traverse in DFS fashion, so going with preorder
        if(root1.left==null && root1.right==null) { ans.add(root1.val); return; }

        toleaf(root1.left, ans);
        toleaf(root1.right, ans);
        return;

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> second=new ArrayList<>();

        toleaf(root1, first);
        toleaf(root2, second);

        
        if(first.size()!=second.size()) return false;
        for(int i=0;i<first.size();i++){
            if(first.get(i)!=second.get(i)) return false;
        }
        return true;
    }
}