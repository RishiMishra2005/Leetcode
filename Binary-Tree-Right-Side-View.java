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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
        return ans;
        func(root,0);
        return ans;
    }
    void func(TreeNode root,int level)
    {
        if(ans.size()==level)
        ans.add(root.val);
        if(root.right!=null)
        func(root.right,level+1);
        if(root.left!=null)
        func(root.left,level+1);
    }
}