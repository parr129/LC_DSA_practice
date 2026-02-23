class Solution {
    public int calculateMinimumHP(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] d = new int[m + 1][n + 1];
        for (int[] x : d) java.util.Arrays.fill(x, Integer.MAX_VALUE);
        d[m][n - 1] = d[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                d[i][j] = Math.max(1, Math.min(d[i + 1][j], d[i][j + 1]) - g[i][j]);
        return d[0][0];
    }
}