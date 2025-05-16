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
    List<Integer> ans;
    
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<Integer>();
        dfs(root, 0);
        return ans;
    }
    
    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        
        if (depth == ans.size()) {
            ans.add(node.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), node.val));
        }
        
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}