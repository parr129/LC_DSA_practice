class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length(), m = 1000000007;
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            long x = 0;
            for (int j = i; j < n; j++) {
                x = x * 10 + (s.charAt(j) - '0');
                if (x > k) break;
                dp[i] = (dp[i] + dp[j + 1]) % m;
            }
        }
        return (int) dp[0];
    }
}