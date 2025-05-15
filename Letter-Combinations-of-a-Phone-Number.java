class Solution {

    static HashMap<Character, String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }
    public void dfs(String digit, int index, StringBuilder current, List<String> result){
        if(index == digit.length()){
            result.add(current.toString());
            return;
        }
        char d = digit.charAt(index);
        String letter = map.get(d);
        for(char i : letter.toCharArray()){
            current.append(i);
            dfs(digit,index+1,current,result);
            current.deleteCharAt(current.length() - 1);
        }
    }

}