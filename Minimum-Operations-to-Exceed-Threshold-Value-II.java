class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            if(num<k) pq.add(num);
        }
        int op = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();
            op++;
            if(pq.isEmpty()) break;
            int y = pq.poll();
            long up = 2l * x + y;
            if(up<k) pq.add((int)up);
        }
        return op;
    }
}