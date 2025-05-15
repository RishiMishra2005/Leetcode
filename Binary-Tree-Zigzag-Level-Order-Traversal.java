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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        int lvl = 1;
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            List<Integer> lvlItems = new ArrayList<>();
            for (int i = 0; i < levelWidth; i++) {
                TreeNode node = queue.poll();
                if (lvl % 2 == 0) {
                    lvlItems.addFirst(node.val);
                } else {
                    lvlItems.addLast(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(lvlItems);
            lvl++;
        }
        return result;
    }
}