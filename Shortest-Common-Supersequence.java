class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String res="";
        try{
        Callable<String> task = () -> generateLCS(str1,str2);
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        res = future.get();
        }catch(Exception e){

        } // Wait for the thread to finish
        return res;

    }

    public String generateLCS(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] lcsMatrix = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }

        int row = l1;
        int col = l2;


        String lcs = "";
        StringBuilder ans = new StringBuilder();
        while (row != 0 && col != 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (lcsMatrix[row - 1][col] > lcsMatrix[row][col - 1]) {
                ans.append(str1.charAt(row - 1));
                row--;
            } else {
                ans.append(str2.charAt(col - 1));
                col--;
            }
        }

        for(int i = l1 - row; i < l1; i++){
            ans.append(str1.charAt(row - 1));
            row--;
        }


        for(int i = l2 - col; i < l2; i++){
            ans.append(str2.charAt(col - 1));
            col--;
        }

        return ans.reverse().toString();
    }
}

