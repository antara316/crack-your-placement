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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        func(0,arr,root);
        return arr;
    }

    public void func(int level, List<Integer> arr, TreeNode root){
        if(root == null) return;
        if (level == arr.size()) arr.add(root.val);
        else arr.set(level, root.val);
        func(level+1,arr,root.left);
        func(level+1,arr,root.right);
    }
}