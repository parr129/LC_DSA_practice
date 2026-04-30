class Solution {
    int[][][] dp;
    int[][] grid;
    int m, n;
    int INF = (int)1e9;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int t = 0; t <= k; t++)
                    dp[i][j][t] = Integer.MIN_VALUE;

        int ans = dfs(m - 1, n - 1, k);
        return ans < 0 ? -1 : ans;
    }

    int dfs(int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) return -INF;
        if (i == 0 && j == 0) return 0;
        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int cost = grid[i][j] == 0 ? 0 : 1;
        int nk = k - cost;

        int best = Math.max(dfs(i - 1, j, nk), dfs(i, j - 1, nk));
        if (best < 0) return dp[i][j][k] = -INF;

        return dp[i][j][k] = best + grid[i][j];
    }
}