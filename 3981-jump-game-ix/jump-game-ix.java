class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; i++)
            pre[i] = Math.max(pre[i - 1], nums[i]);

        int suf = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (pre[i] > suf)
                ans[i] = ans[i + 1];
            else
                ans[i] = pre[i];

            suf = Math.min(suf, nums[i]);
        }

        return ans;
    }
}