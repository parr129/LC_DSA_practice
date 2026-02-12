class Solution {
    public int change(int a, int[] c) {
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for (int x : c)
            for (int i = x; i <= a; i++)
                dp[i] += dp[i - x];
        return dp[a];
    }
}
