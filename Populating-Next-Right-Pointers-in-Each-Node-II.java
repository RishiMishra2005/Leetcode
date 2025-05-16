/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node dummy = new Node();
        Node cur = root;
        while (cur != null) {
            Node temp = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    temp.next = cur.left;
                    temp = temp.next;
                }
                if (cur.right != null) {
                    temp.next = cur.right;
                    temp = temp.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
            dummy.next = null;
        }
        return root;
    }
}