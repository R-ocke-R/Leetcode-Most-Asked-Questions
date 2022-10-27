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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode curr=root;
        while(curr!=null || stack.size()>0){
            // inorder= left
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //print
            curr=stack.pop();
            answer.add(curr.val);
            //right
            curr=curr.right;
        }
        return answer;
    }
}