/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // First find path from root to target
        List<TreeNode> path = new LinkedList<TreeNode>();
        getPath(root, target, path);

        // Create a list of ancestors to prevent revisiting (e.g. X -> Y -> X should not count)
        Set<TreeNode> ancestors = new HashSet<TreeNode>(path);
        
        // Iterate through the list of ancestors and add to return list recursively
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < path.size(); i++) {
            int depth = k - i;
            search(path.get(i), ret, ancestors, depth);
        }
        return ret;
    }

    public boolean getPath(TreeNode curr, TreeNode target, List<TreeNode> path) {
        if (curr == null) return false;
        
        path.add(0, curr);
        if (curr == target) {
            return true;
        }
        boolean left = getPath(curr.left, target, path);
        boolean right = getPath(curr.right, target, path);
        if (!left && !right) {
            path.remove(0);
            return false;
        }
        return left || right;
    }

    public boolean search(TreeNode curr, List<Integer> path, Set<TreeNode> ancestors, int depth) {
        if (curr == null) return false;
        if (depth == 0) {
            path.add(curr.val);
        }
        if (!ancestors.contains(curr.left)) search(curr.left, path, ancestors, depth - 1);
        if (!ancestors.contains(curr.right)) search(curr.right, path, ancestors, depth - 1);
        return true;
    }
}