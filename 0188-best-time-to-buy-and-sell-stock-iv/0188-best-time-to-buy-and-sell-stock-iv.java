class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        if (n < 2) return 0;
        if (k >= n/2) {
            int r = 0;
            for (int i = 1; i < n; ++i) if (p[i] > p[i-1]) r += p[i] - p[i-1];
            return r;
        }
        int[][] dp = new int[k+1][2];
        for (int i = 0; i <= k; ++i) dp[i][1] = -1_000_000_000;
        dp[0][1] = -1_000_000_000;
        for (int x : p) {
            for (int i = k; i > 0; --i) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + x);
                dp[i][1] = Math.max(dp[i][1], dp[i-1][0] - x);
            }
        }
        int r = 0;
        for (int i = 0; i <= k; ++i) r = Math.max(r, dp[i][0]);
        return r;
    }
}
