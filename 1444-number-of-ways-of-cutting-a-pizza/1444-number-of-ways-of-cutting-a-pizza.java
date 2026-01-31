class Solution {
    int M = 1000000007;
    public int ways(String[] p, int k) {
        int n = p.length, m = p[0].length();
        int[][] ps = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                ps[i][j] = ps[i + 1][j] + ps[i][j + 1] - ps[i + 1][j + 1] + (p[i].charAt(j) == 'A' ? 1 : 0);
        Integer[][][] dp = new Integer[n][m][k + 1];
        return f(0, 0, k, ps, dp);
    }
    int f(int i, int j, int c, int[][] ps, Integer[][][] dp) {
        if (ps[i][j] == 0) return 0;
        if (c == 1) return 1;
        if (dp[i][j][c] != null) return dp[i][j][c];
        int r = 0;
        for (int x = i + 1; x < ps.length - 1; x++)
            if (ps[i][j] - ps[x][j] > 0)
                r = (r + f(x, j, c - 1, ps, dp)) % M;
        for (int y = j + 1; y < ps[0].length - 1; y++)
            if (ps[i][j] - ps[i][y] > 0)
                r = (r + f(i, y, c - 1, ps, dp)) % M;
        return dp[i][j][c] = r;
    }
}
