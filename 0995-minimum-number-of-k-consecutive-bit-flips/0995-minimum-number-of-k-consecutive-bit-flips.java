class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length, ans = 0, flip = 0;
        int[] is = new int[n];
        for (int i = 0; i < n; i++) {
            if (i >= k) flip ^= is[i - k];
            if (nums[i] == flip) {
                if (i + k > n) return -1;
                ans++;
                flip ^= 1;
                is[i] = 1;
            }
        }
        return ans;
    }
}