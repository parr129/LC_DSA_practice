class Solution {
    long m = 1000000007L;
    long[][] c = new long[1001][1001];

    public int numOfWays(int[] a) {
        int n = a.length;
        for (int i = 0; i <= n; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++)
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % m;
        }
        return (int)((f(a) - 1 + m) % m);
    }

    long f(int[] a) {
        int n = a.length;
        if (n <= 2) return 1;
        int r = a[0], l = 0;
        for (int x : a) if (x < r) l++;
        int[] L = new int[l], R = new int[n - l - 1];
        int i = 0, j = 0;
        for (int k = 1; k < n; k++) {
            if (a[k] < r) L[i++] = a[k];
            else R[j++] = a[k];
        }
        long x = f(L), y = f(R);
        return (((c[n - 1][l] * x) % m) * y) % m;
    }
}