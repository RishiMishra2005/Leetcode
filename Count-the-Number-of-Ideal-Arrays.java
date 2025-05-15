import java.math.BigInteger;

class Solution {
	public static final int MODULO = (int) 1e9 + 7;

	public static int idealArrays(int n, int maxValue) {
		int[] minDivisor = new int[maxValue + 1];
		for (int p = 2; p <= maxValue; p++) {
			if (minDivisor[p] != 0)
				continue;
			for (int i = p; i <= maxValue; i += p)
				if (minDivisor[i] == 0)
					minDivisor[i] = p;
		}
		
		int maxPow = (int) (Math.log(maxValue) / Math.log(2));
		int[] binCoeff = new int[maxPow + 1];
		BigInteger b = BigInteger.ONE;
		BigInteger bigMod = BigInteger.valueOf(MODULO);
		for (int i = 1; i <= maxPow; i++) {
			b = b.multiply(BigInteger.valueOf(n + i - 1));
			b = b.divide(BigInteger.valueOf(i));
			binCoeff[i] = b.mod(bigMod).intValue();
		}
		
		int s = 0;
		for (int i = 1; i <= maxValue; i++) {
			int x = i;
			long prodBin = 1;
			while (x > 1) {
				int p = minDivisor[x];
				int w = 0;
				do {
					w++;
					x /= p;
				} while (x % p == 0);
				prodBin = prodBin * binCoeff[w] % MODULO;
			}
			s = (s + (int) prodBin) % MODULO;
		}
		return s;
	}
}