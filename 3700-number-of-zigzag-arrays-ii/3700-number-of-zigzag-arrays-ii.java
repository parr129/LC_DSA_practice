class Solution {
    static final long MOD = 1000000007L;

    long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }

    long[] mul(long[][] a, long[] v) {
        int n = a.length;
        long[] r = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                r[i] = (r[i] + a[i][j] * v[j]) % MOD;
            }
        }
        return r;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int s = 2 * m;

        long[][] t = new long[s][s];

        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                t[m + y][x] = 1;
            }
            for (int y = 0; y < x; y++) {
                t[y][m + x] = 1;
            }
        }

        long[] v = new long[s];
        for (int i = 0; i < s; i++) v[i] = 1;

        int p = n - 1;

        while (p > 0) {
            if ((p & 1) == 1) v = mul(t, v);
            t = mul(t, t);
            p >>= 1;
        }

        long ans = 0;
        for (long x : v) ans = (ans + x) % MOD;

        return (int) ans;
    }
}