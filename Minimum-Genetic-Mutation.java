class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : bank){
            map.put(s, -1);
        }
        map.put(startGene, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            int numOfMutations = map.get(curr);
            if(curr.equals(endGene)){
                return numOfMutations;
            }

            for(String s : bank){
                if(map.get(s) == -1 && numOfDifferences(curr, s) == 1){
                    map.put(s, numOfMutations +1);
                    queue.offer(s);
                }
            }
        }
        return -1;
    }

    public static int numOfDifferences(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int numOfDifferences = 0;
        for(int i = 0; i < s1.length(); i++){
            if (chars1[i] != chars2[i])
                numOfDifferences++;
        }
        return numOfDifferences;
    }
}