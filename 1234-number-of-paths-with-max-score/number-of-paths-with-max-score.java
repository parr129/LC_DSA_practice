class Solution {
    public int[] pathsWithMaxScore(List<String> b) {
        int n = b.size(), MOD = 1000000007;
        int[][] dp = new int[n][n], cnt = new int[n][n];
        cnt[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = b.get(i).charAt(j);
                if (c == 'X' || (i == n - 1 && j == n - 1)) continue;

                int best = -1, ways = 0;
                int[][] d = {{1, 0}, {0, 1}, {1, 1}};

                for (int[] x : d) {
                    int r = i + x[0], s = j + x[1];
                    if (r < n && s < n && cnt[r][s] > 0) {
                        if (dp[r][s] > best) {
                            best = dp[r][s];
                            ways = cnt[r][s];
                        } else if (dp[r][s] == best) {
                            ways = (ways + cnt[r][s]) % MOD;
                        }
                    }
                }

                if (best == -1) continue;
                cnt[i][j] = ways;
                dp[i][j] = best + (c == 'E' ? 0 : c - '0');
            }
        }
        return new int[]{cnt[0][0] == 0 ? 0 : dp[0][0], cnt[0][0]};
    }
}