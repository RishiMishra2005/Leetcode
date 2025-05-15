class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backtracking(ret, new StringBuilder(), 0, 0, n);
        return ret;
    }

    private void backtracking(List<String> list, StringBuilder sb, int left, int right, int n){
        if(left + right == n * 2){
            list.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            backtracking(list, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left > right){
            sb.append(")");
            backtracking(list, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }  
}