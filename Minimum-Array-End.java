class Solution {
    public long minEnd(int n, int x) {
        // Convert x and n-1 into binary strings
        String binaryString = Integer.toBinaryString(n - 1);
        String startString = Integer.toBinaryString(x);

        int a = startString.length() - 1;
        int b = binaryString.length() - 1;
        StringBuilder sBuilder = new StringBuilder();

        while (true) {
            if (a == -1 && b == -1) {
                break;
            } else {
                if (a == -1) {
                    while (b != -1) {
                        sBuilder.insert(0, binaryString.charAt(b));
                        b--;
                    }
                    break;
                } else if (b == -1) {
                    while (a != -1) {
                        sBuilder.insert(0, startString.charAt(a));
                        a--;
                    }
                } else {
                    char atStart = startString.charAt(a);
                    char atBin = binaryString.charAt(b);

                    if (atStart == '1') {
                        sBuilder.insert(0, atStart);
                        a--;
                    } else {
                        sBuilder.insert(0, atBin);
                        a--;
                        b--;
                    }
                }
            }
        }

        // Convert the binary string to a decimal number
        long result = 0;
        int length = sBuilder.length();
        for (int i = 0; i < length; i++) {
            result = result * 2 + (sBuilder.charAt(i) - '0');
        }

        return result;
    }
}