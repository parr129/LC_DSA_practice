class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        
        long evenWays = power(5, evenCount, mod);
        long oddWays = power(4, oddCount, mod);
        
        return (int)((evenWays * oddWays) % mod);
    }

    // Fast exponentiation (modular power)
    private long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {  //  odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;  
        }

        return result;
    }
}
