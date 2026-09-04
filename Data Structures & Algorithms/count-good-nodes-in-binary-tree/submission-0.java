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
    public int goodNodes(TreeNode root) {
        return dfs(root, -101);
    }

    private int dfs(TreeNode curr, int max){
        int result = 0;

        if(curr.val >= max){
            result = 1;
            max = curr.val;
        }

        if(curr.left != null) result += dfs(curr.left, max);
        if(curr.right != null) result += dfs(curr.right, max);
        return result;
    }
}
