class Solution {
    public String clearStars(String s) {
        int n = s.length();
        byte[] buf = new byte[n + 1];
        s.getBytes(0, n, buf, 0);
        buf[n] = '*';

        int start = 0, stars = 0;
        for (int i = 0; i < n; i++) {
            if (buf[i] == '*') {
                stars++;
                if (stars == ((i + 2) >> 1))
                    start = i + 1;
            }
        }
        if (stars == 0)
            return s;
        if (start == n)
            return "";

        int[] link = new int[n];
        int[] head = new int[128];
        for (int i = 'a'; i <= 'z'; i++)
            head[i] = -1;

        for (int i = start;; i++) {
            int ch = buf[i];
            if (ch == '*') {
                if (i >= n)
                    break;
                buf[i] = 0;
                for (int c = 'a';; c++) {
                    if (head[c] >= 0) {
                        buf[head[c]] = 0;
                        head[c] = link[head[c]];
                        break;
                    }
                }
            } else {
                link[i] = head[ch];
                head[ch] = i;
            }
        }

        int out = 0;
        for (int i = start; i < n; i++) {
            if (buf[i] != 0)
                buf[out++] = buf[i];
        }

        return new String(buf, 0, out);
    }
}