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
class FindElements {
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        recoverTree(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    private void recoverTree(TreeNode root, int value) {
        if (root == null) return;
        set.add(value);
        root.val = value;
        recoverTree(root.left, 2 * value + 1);
        recoverTree(root.right, 2 * value + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */