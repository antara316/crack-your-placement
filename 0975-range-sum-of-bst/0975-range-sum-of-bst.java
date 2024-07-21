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
    int sum = 0;
// using the preOrder traversal TECHNIQUE    
    private void preOrder(TreeNode root, int low, int high){
        if(root != null){
            if(root.val>=low && root.val<=high){
                sum += root.val;
            }
            preOrder(root.left, low, high);
            preOrder(root.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
/*
// This is The EFFICIENT WAY TO SOLVE THIS....
// EDGE CASE HANDLE.....
        if(root == null){
            return 0;
        }


        if(root.val>=low && root.val<=high){
            sum+=root.val;
        }
        if(root.val > low){
            rangeSumBST(root.left, low, high);
        }
        if(root.val < high){
            rangeSumBST(root.right, low, high);
        }
        return sum;
*/

        preOrder(root, low, high);
        return sum;
    }
}