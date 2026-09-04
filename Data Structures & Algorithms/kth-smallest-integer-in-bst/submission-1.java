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
    private int result;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        result = root.val;
        this.k = k;

        dfs(root);
        return result;
    }

    private int dfs(TreeNode curr) {
        if(k < 1) return 0;

        if(curr.left != null) k = dfs(curr.left);

        if(k == 1){
            result = curr.val;
            return 0;
        }

        k--;

        if(curr.right != null) k = dfs(curr.right);

        return k;
    }
}
