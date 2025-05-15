class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         return new java.util.AbstractList<>(){
                List<List<Integer>> result = new ArrayList<>();
                private void helper(int i, int sum, List<Integer> list) {
                    if (i>=candidates.length||sum <= 0) {
                        if (sum == 0) result.add(new ArrayList<>(list));
                        return;
                    }
                    if (sum - candidates[i] >=0 ) {
                        list.add(candidates[i]);
                        helper(i, sum - candidates[i], list);
                        list.remove(list.size() - 1);
                    }
                    helper(i + 1, sum, list);

                    return;
                }
                public List<Integer> get(int i){
                    if(result.size()==0)helper(0,target,new ArrayList<>());
                    return result.get(i); 
                }
                public int size(){
                    if(result.size()==0)helper(0,target,new ArrayList<>());
                    return result.size();
                }
            };
    }
    
}