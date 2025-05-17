class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(map.containsKey(sch)){
                if(map.get(sch)!=tch){
                    return false;
                }
            }
            else if(map.containsValue(tch)){
                return false;
            }
            else {
                map.put(sch,tch);
            }
        }
        return true;
    }
}