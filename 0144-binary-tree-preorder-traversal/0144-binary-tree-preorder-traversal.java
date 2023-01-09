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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> answer=new ArrayList<>();
    //     dfs(root, answer);
    //     return answer;
    // }
    // public void dfs(TreeNode root, List<Integer> answer){
    //     if(root == null) return ;
    //     answer.add(root.val);
    //     dfs(root.left, answer);
    //     dfs(root.right, answer);
    // }

    public List<Integer> preorderTraversal(TreeNode root){
        //iterative
        List<Integer> answer= new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp= stack.pop();
            if(temp==null) return answer;
            answer.add(temp.val);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
        return answer;
    }






}