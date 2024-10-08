class Solution {
    // Static variable to keep track of the current level
    static int n;

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Get the total number of levels in the tree
        int m = levels(root);
        
        // Initialize the result list
        List<List<Integer>> ans = new ArrayList<>();
        
        // Iterate through each level
        for (int x = 0; x < m; x++) {
            n = x;  // Set the current level
            List<Integer> helper = new ArrayList<>();  // List to store nodes at current level
            nThLevel(root, 0, helper);  // Traverse the tree for current level
            ans.add(helper);  // Add the current level's nodes to the result
        }
        return ans;
    }

    // Helper method to traverse the tree and collect nodes at the nth level
    private static void nThLevel(TreeNode root, int level, List<Integer> helper) {
        if (root == null) return;  // Base case: if node is null, return
        
        if (level == n) helper.add(root.val);  // If current level matches n, add node value
        
        // Recursively traverse left and right subtrees
        nThLevel(root.left, level + 1, helper);
        nThLevel(root.right, level + 1, helper);
    }

    // Helper method to calculate the height of the tree
    private static int levels(TreeNode root) {
        if (root == null) return 0;  // Base case: if node is null, height is 0
        
        // Recursively calculate height of left and right subtrees
        int a = levels(root.left);
        int b = levels(root.right);
        
        // Return the maximum height plus 1 for the current node
        return 1 + Math.max(a, b);
    }
}