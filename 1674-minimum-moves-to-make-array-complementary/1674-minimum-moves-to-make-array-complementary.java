class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] d = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            d[2] += 2;
            d[a + 1]--;
            d[a + b]--;
            d[a + b + 1]++;
            d[b + limit + 1]++;
        }

        int ans = Integer.MAX_VALUE, cur = 0;

        for (int s = 2; s <= 2 * limit; s++) {
            cur += d[s];
            ans = Math.min(ans, cur);
        }

        return ans;
    }
}