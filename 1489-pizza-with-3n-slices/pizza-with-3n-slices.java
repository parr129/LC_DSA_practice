class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        return Math.max(helper(slices, 0, n - 2), helper(slices, 1, n - 1));
    }

    private int helper(int[] arr, int start, int end) {
        int m = end - start + 1;
        int k = arr.length / 3;
        int[][] dp = new int[m + 1][k + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                int take = arr[start + i - 1];
                if (i > 1) take += dp[i - 2][j - 1];
                dp[i][j] = Math.max(dp[i - 1][j], take);
            }
        }
        return dp[m][k];
    }
}