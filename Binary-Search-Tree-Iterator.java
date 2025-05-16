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
class BSTIterator {
    private TreeNode curr = null;
    public BSTIterator(TreeNode root) {
        curr = root;
    }
    
    public int next() {
        int rv = -1;
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                rv = curr.val;
                curr = curr.right;
                break;
            }else{
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    rv = curr.val;
                    curr = curr.right;
                    break;
                }
            }
        }
        return rv;
    }
    public TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr){
        while(leftNode.right != null && leftNode.right != curr)leftNode = leftNode.right;
        return leftNode;
    }
    public boolean hasNext() {
        return curr!=null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */