class Solution {
    public int maxBuilding(int n, int[][] r) {
        int m = r.length;
        int[][] a = new int[m + 1][2];
        a[0] = new int[]{1, 0};
        for (int i = 0; i < m; i++) a[i + 1] = r[i];

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        int k = a.length;
        int[] h = new int[k];
        for (int i = 0; i < k; i++) h[i] = a[i][1];

        for (int i = 1; i < k; i++)
            h[i] = Math.min(h[i], h[i - 1] + a[i][0] - a[i - 1][0]);

        for (int i = k - 2; i >= 0; i--)
            h[i] = Math.min(h[i], h[i + 1] + a[i + 1][0] - a[i][0]);

        long ans = 0;
        for (int i = 1; i < k; i++) {
            int d = a[i][0] - a[i - 1][0];
            ans = Math.max(ans, (long)(h[i] + h[i - 1] + d) / 2);
        }

        ans = Math.max(ans, h[k - 1] + n - a[k - 1][0]);
        return (int) ans;
    }
}