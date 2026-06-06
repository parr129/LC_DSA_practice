class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 0, left = 0;

        for (int num : nums) total += num;

        for (int i = 0; i < n; i++) {
            total -= nums[i];
            ans[i] = Math.abs(left - total);
            left += nums[i];
        }

        return ans;
    }
}