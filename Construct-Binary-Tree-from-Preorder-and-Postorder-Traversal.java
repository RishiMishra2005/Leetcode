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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, preorder.length - 1, 0);
    }
     private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart) {
        if(preStart > preEnd || postStart >= postorder.length || preStart >= preorder.length ) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);

        TreeNode root = new TreeNode(preorder[preStart]);
        int leftRoot = preorder[preStart + 1];
        int leftNodeCount = 1;
        while(leftRoot != postorder[postStart + leftNodeCount - 1]) leftNodeCount++;

        TreeNode leftNode = helper(preorder, postorder, preStart + 1, preStart + leftNodeCount, postStart);
        root.left = leftNode;
        TreeNode rightNode = helper(preorder, postorder, preStart + leftNodeCount + 1, preEnd, postStart + leftNodeCount);
        root.right = rightNode;
        return root;
     }
}