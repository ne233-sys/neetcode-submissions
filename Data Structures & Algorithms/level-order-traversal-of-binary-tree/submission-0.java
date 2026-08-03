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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> p = new LinkedList<>();
        Queue<TreeNode> c = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        TreeNode curr = new TreeNode();

        p.offer(root);

        //if(root.left != null) c.offer(root.left);
        //if(root.right != null) c.offer(root.right);

        while(!p.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            while(!p.isEmpty())
            {
                curr = p.poll();
                temp.add(curr.val);

                if(curr.left != null) c.offer(curr.left);
                if(curr.right != null) c.offer(curr.right);
            }
            list.add(temp);

            p = c;
            c = new LinkedList<>();
        }

        return list;
    }
}
