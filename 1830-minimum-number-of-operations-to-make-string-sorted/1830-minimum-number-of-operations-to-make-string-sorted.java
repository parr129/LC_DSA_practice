class Solution {
    static final long M = 1000000007;

    public int makeStringSorted(String s) {
        int n = s.length();
        long[] f = new long[n + 1];
        long[] inv = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) f[i] = f[i - 1] * i % M;

        inv[n] = pow(f[n], M - 2);
        for (int i = n - 1; i >= 0; i--) inv[i] = inv[i + 1] * (i + 1) % M;

        int[] c = new int[26];
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int x = s.charAt(i) - 'a';
            c[x]++;
            int less = 0;
            for (int j = 0; j < x; j++) less += c[j];
            if (less == 0) continue;

            long ways = less * f[n - i - 1] % M;
            for (int j = 0; j < 26; j++) ways = ways * inv[c[j]] % M;
            ans = (ans + ways) % M;
        }
        return (int) ans;
    }

    long pow(long a, long b) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) == 1) r = r * a % M;
            a = a * a % M;
            b >>= 1;
        }
        return r;
    }
}