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
    public int kthSmallest(TreeNode root, int k) {
        result = root.val;

        dfs(root, k);
        return result;
    }

    private int dfs(TreeNode curr, int k) {
        if(k < 1) return 0;

        if(curr.left != null) k = dfs(curr.left, k);

        if(k == 1){
            result = curr.val;
            return 0;
        }

        k--;

        if(curr.right != null) k = dfs(curr.right, k);

        return k;
    }
}
