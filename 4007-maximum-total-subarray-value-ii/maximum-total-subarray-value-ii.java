class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length, m = 32 - Integer.numberOfLeadingZeros(n);
        int[][] mx = new int[m][n], mn = new int[m][n];
        for (int i = 0; i < n; i++) mx[0][i] = mn[0][i] = nums[i];
        for (int j = 1; j < m; j++)
            for (int i = 0; i + (1 << j) <= n; i++) {
                mx[j][i] = Math.max(mx[j - 1][i], mx[j - 1][i + (1 << (j - 1))]);
                mn[j][i] = Math.min(mn[j - 1][i], mn[j - 1][i + (1 << (j - 1))]);
            }

        java.util.function.BiFunction<Integer, Integer, Long> val = (l, r) -> {
            int len = r - l + 1;
            int p = 31 - Integer.numberOfLeadingZeros(len);
            int ma = Math.max(mx[p][l], mx[p][r - (1 << p) + 1]);
            int mi = Math.min(mn[p][l], mn[p][r - (1 << p) + 1]);
            return (long) ma - mi;
        };

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for (int l = 0; l < n; l++) pq.offer(new long[]{val.apply(l, n - 1), l, n - 1});

        long ans = 0;
        while (k-- > 0) {
            long[] cur = pq.poll();
            ans += cur[0];
            int l = (int) cur[1], r = (int) cur[2];
            if (r > l) pq.offer(new long[]{val.apply(l, r - 1), l, r - 1});
        }
        return ans;
    }
}