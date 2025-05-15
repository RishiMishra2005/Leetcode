class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i % 2 == 0 && i > 2)
                continue;
            if (isPrime(i)) {
                if (primes.isEmpty() == false && i <= primes.get(primes.size() - 1) + 2) {
                    return new int[] { primes.get(primes.size() - 1), i };
                }
                primes.add(i);
            }
        }
        if (primes.size() < 2)
            return new int[] { -1, -1 };
        int[] res = new int[2];
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDif) {
                minDif = diff;
                res[0] = primes.get(i - 1);
                res[1] = primes.get(i);
            }
        }
        return res;
    }

    boolean isPrime(int x) {
        if (x == 1)
            return false;
        for (int i = 3; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}