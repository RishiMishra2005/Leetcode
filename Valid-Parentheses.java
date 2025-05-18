class Solution {
    public boolean isValid(String s) {
        Stack<Character> x = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='('){
                x.push(')');
            }
            else if (c=='{'){
                x.push('}');
            }
            else if(c=='['){
                x.push(']');
            }
            else if (x.isEmpty() || x.pop()!=c){
                return false;
            }
        }
        return x.isEmpty();
    }
}