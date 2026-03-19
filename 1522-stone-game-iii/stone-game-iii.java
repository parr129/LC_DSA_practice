class Solution {
    public String stoneGameIII(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int s = 0;
            for (int j = i; j < Math.min(n, i + 3); j++) {
                s += a[j];
                dp[i] = Math.max(dp[i], s - dp[j + 1]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}