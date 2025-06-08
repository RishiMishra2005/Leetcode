class Solution {
    static int parent[];

    public static int find(int val) {
        if (parent[val] != val) {
            parent[val] = find(parent[val]);

        }
        return parent[val];
    }

    public static void union(int a, int b) {
        int leta = find(a);
        int letb = find(b);

        if (leta < letb) {
            parent[letb] = leta;
        } else {
            parent[leta] = letb;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = baseStr.length();
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char chh = baseStr.charAt(i);
            res.append((char) (find(chh - 'a') + 'a'));
        }
        return res.toString();
    }
}