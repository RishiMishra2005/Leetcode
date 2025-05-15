/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Set<Integer> set;
    Map<Integer, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        set = new HashSet<>();
        map = new HashMap<>();
        
        Node root = new Node(node.val, new ArrayList<>());
        map.put(root.val, root);
        
        dfs(node, root);
        return root;
    }

    private void dfs(Node old, Node curr) {
        if (old == null) return;
        if (set.contains(old.val)) return;
        
        set.add(old.val);

        for (var nh : old.neighbors) {
            if (!map.containsKey(nh.val)) {
                Node newNode = new Node(nh.val, new ArrayList<>());
                curr.neighbors.add(newNode);
                map.put(newNode.val, newNode);
            } else curr.neighbors.add(map.get(nh.val));
        }

        for (int i = 0; i < old.neighbors.size(); i++) {
            dfs(old.neighbors.get(i), curr.neighbors.get(i));
        }
    }
}