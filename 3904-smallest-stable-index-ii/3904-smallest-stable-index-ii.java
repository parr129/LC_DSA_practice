class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n];

        r[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.min(r[i + 1], nums[i]);
        }

        int m = 0;

        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);

            if (m - r[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}