class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            sum1+=gas[i];
            sum2+=cost[i];
        }
        if(sum1<sum2){
            return -1;
        }
        int remaining_fuel=0;
        int ans=0;
        for(int i=0;i<n;i++){
            remaining_fuel+=gas[i]-cost[i];
            if(remaining_fuel<0){
                ans=i+1;
                remaining_fuel=0;
            }
        }
        return ans;
    }
}