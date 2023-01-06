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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        return merge(list1, list2);
    }
    static List<Integer> merge(List<Integer> l1, List<Integer> l2){
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) <= l2.get(j))
                list.add(l1.get(i++));
            else
                list.add(l2.get(j++));
        }
        while(i < l1.size())
            list.add(l1.get(i++));
        while(j < l2.size())
            list.add(l2.get(j++));
        return list;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
