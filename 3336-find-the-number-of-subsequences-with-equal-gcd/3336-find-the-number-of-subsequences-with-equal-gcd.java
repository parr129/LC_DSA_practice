class Solution {
    static final int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int m = 0;
        for (int x : nums) m = Math.max(m, x);
        long[][] dp = new long[m + 1][m + 1];
        dp[0][0] = 1;
        for (int x : nums) {
            long[][] nd = new long[m + 1][m + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= m; j++) {
                    long v = dp[i][j];
                    if (v == 0) continue;
                    nd[i][j] = (nd[i][j] + v) % MOD;
                    nd[gcd(i, x)][j] = (nd[gcd(i, x)][j] + v) % MOD;
                    nd[i][gcd(j, x)] = (nd[i][gcd(j, x)] + v) % MOD;
                }
            }
            dp = nd;
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) ans = (ans + dp[i][i]) % MOD;
        return (int) ans;
    }

    int gcd(int a, int b) {
        while (a != 0) {
            int t = b % a;
            b = a;
            a = t;
        }
        return b;
    }
}