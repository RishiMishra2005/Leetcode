class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for(String s : tokens) {
            char c = s.charAt(0);
            if(c=='+') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a+b;
            } else if(c=='-' && s.length()==1) {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a-b;
            } else if(c=='*') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a*b;
            } else if(c=='/') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a/b;
            } else 
                stack[top++] = Integer.parseInt(s);
        }
        return stack[0];
    }
}