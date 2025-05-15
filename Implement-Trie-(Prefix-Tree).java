class Trie {
    Node root = new Node();
    public Trie() {
        
    }
    
    public void insert(String word) {
        find(word, true, false);
    }
    
    public boolean search(String word) {
        return find(word, false, false);
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix, false, true);
    }

    private boolean find(String word, boolean isInsert, boolean isPrefix) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                if (isInsert) {
                    node.children[c - 'a'] = new Node();
                } else {
                    return false;
                }
            }
            node = node.children[c - 'a'];
        }
        if (isInsert) {
            node.count++;
        }

        if (isPrefix) {
            return true;
        }
        return node.count > 0;
    }

    public static class Node {
        int count = 0;
        Node[] children = new Node[26];
        public Node() {}
    }
}