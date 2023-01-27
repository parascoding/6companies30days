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
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }
    static int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0, 0};
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        int ret[] = new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
        if(ret[0] / ret[1] == root.val)
            count++;
        return ret;
    }
    static int count;
}
