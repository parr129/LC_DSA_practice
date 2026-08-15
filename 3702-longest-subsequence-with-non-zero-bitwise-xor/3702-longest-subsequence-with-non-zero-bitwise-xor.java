class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0, nonZero = 0;
        for (int n : nums) {
            x ^= n;
            if (n != 0) nonZero++;
        }
        if (x != 0) return nums.length;
        return nonZero == 0 ? 0 : nums.length - 1;
    }
}