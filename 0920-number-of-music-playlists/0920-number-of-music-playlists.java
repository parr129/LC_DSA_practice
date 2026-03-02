class Solution {
    public int numMusicPlaylists(int n, int g, int k) {
        long m = 1000000007L;
        long[][] d = new long[g + 1][n + 1];
        d[0][0] = 1;
        for (int i = 1; i <= g; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                d[i][j] = (d[i - 1][j - 1] * (n - j + 1)) % m;
                if (j > k)
                    d[i][j] = (d[i][j] + d[i - 1][j] * (j - k)) % m;
            }
        }
        return (int) d[g][n];
    }
}