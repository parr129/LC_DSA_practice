class Solution {
    static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;
        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        for (int len = 3; len <= n; len++) {
            long[] nu = new long[m];
            long[] nd = new long[m];
            long p = 0, s = 0;

            for (int i = 0; i < m; i++) {
                nu[i] = p;
                p = (p + down[i]) % MOD;
            }
            for (int i = m - 1; i >= 0; i--) {
                nd[i] = s;
                s = (s + up[i]) % MOD;
            }

            up = nu;
            down = nd;
        }

        long ans = 0;
        for (int i = 0; i < m; i++)
            ans = (ans + up[i] + down[i]) % MOD;

        return (int) ans;
    }
}