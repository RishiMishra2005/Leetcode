class Solution {
    public static final int MOD = (int)1e9 + 7;
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size(), max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = nums.get(i);
        for(int num : arr) max = Math.max(max, num);
        
        int[] primeScores = getPrimeScores(arr, max);
        
        int[] multiplierCnt = new int[max + 1]; //count how many different subarrays exist where this will be chosen multtiplier (i.e. has greatest prime score and is greatest num amoung those with such a score)
        int[] greaterThanLeft = new int[n]; //gives tthe rightmost index tto the left of an element with greatter prime score/equal score and greater value to current
        int[] greaterThanRight = new int[n]; //index of lefttmostt element to the right of curr with greater score 
        greaterThanLeft[0] = -1;
        greaterThanRight[n-1] = n;
        for(int i = 1; i < n; i++) {
            int left = i-1;
            while(left >= 0 && (primeScores[arr[i]] > primeScores[arr[left]])) left = greaterThanLeft[left];
            greaterThanLeft[i] = left;

            int right = n-i;
            while(right < n && (primeScores[arr[n-i-1]] >= primeScores[arr[right]])) right = greaterThanRight[right];
            greaterThanRight[n-i-1] = right;
        }

        for(int i = 0; i < n; i++) {
            /*can expand array from (left, right) (exclusive on both) so max array where this is max score element is sz = right-left-1, and sz gives total number of subarrays = sz*(sz+1)/2 in range
            however, need center in so subtract all suubarrays without center = subtract triangular of i-left-1 and right-i-1*/
            int sz = greaterThanRight[i]-greaterThanLeft[i]-1, leftSz = i-greaterThanLeft[i]-1, rightSz = greaterThanRight[i]-i-1;
            long subarrays = ((sz*(sz+1L))/2 - (leftSz*(leftSz+1L))/2 - (rightSz*(rightSz+1L))/2);
            multiplierCnt[arr[i]] = (int)Math.min(k, multiplierCnt[arr[i]] + subarrays); //add to the cnt, capping cnt as k as will never use > k multipliers
            
        }


        long res = 1;
        for(int mult = max; mult > 0; mult--) {
            if(multiplierCnt[mult] == 0) continue;
            if(multiplierCnt[mult] >= k) {
                res = (res * modExp(mult, k)) % MOD;
                break;
            } else {
                res = (res * modExp(mult, multiplierCnt[mult])) % MOD; 
                k -= multiplierCnt[mult];
            }
        }

        return (int)res;
    }

    private static int[] getPrimeScores(int[] nums, int max) {
        int[] spf = sieveSmallestPFactors(max);
        int[] primeScores = new int[max + 1];
        for(int num : nums) {
            if(primeScores[num] != 0) continue; //dupe value with already computed prime score
            int x = num;
            while(x > 1) {
                primeScores[num]++;
                int p = spf[x];
                while(spf[x] == p) x /= p;
            }
        }

        return primeScores;
    }

    private static int[] sieveSmallestPFactors(int lim) {
        int[] spf = new int[lim + 1]; //smallest prime factor
        boolean stopPostItr = false;
        for(int i = 3; i <= lim; i += 2) {
            spf[i-1] = 2;
            if(spf[i] != 0) continue;
            spf[i] = i;

            if(stopPostItr) continue;
            stopPostItr = i*i > lim;

            for(int j = i*i; j <= lim; j += 2*i) {
                if(spf[j] == 0) spf[j] = i;
            }
        }
        if(lim % 2 == 0) spf[lim] = 2;
        return spf;
    }

    private static long modExp(int base, int exp) {
        long multiplier = base, res = 1;
        while(exp > 0) {
            if((exp & 1) == 1) res = (res * multiplier) % MOD;
            multiplier = (multiplier * multiplier) % MOD;
            exp >>= 1;
        }
        return res;
    }


}