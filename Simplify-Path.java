class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String di[]= path.split("/");
        for (String d:di){
            if(d.equals(".")|| d.isEmpty()){
                continue;
            }
            else if(d.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(d);
            }
        }
        return "/" + String.join("/",stack);
    }
}