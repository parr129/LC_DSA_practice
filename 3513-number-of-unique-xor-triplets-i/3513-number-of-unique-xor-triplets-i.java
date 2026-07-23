class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int m = 1;
        while (m <= mx) m <<= 1;
        m <<= 1;

        int[] f = new int[m];
        for (int x : nums) f[x] = 1;

        fwt(f, false);

        for (int i = 0; i < m; i++) f[i] = f[i] * f[i] * f[i];

        fwt(f, true);

        int ans = 0;
        for (int x : f) if (x != 0) ans++;
        return ans;
    }

    private void fwt(int[] a, boolean inv) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += len << 1) {
                for (int j = 0; j < len; j++) {
                    int x = a[i + j];
                    int y = a[i + j + len];
                    a[i + j] = x + y;
                    a[i + j + len] = x - y;
                }
            }
        }
        if (inv) {
            for (int i = 0; i < n; i++) a[i] /= n;
        }
    }
}