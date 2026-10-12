
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[31];
        int mod = 1000000007;

        for (int x : nums) {
            for (int i = 0; i < 31; i++) {
                if (((x >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }

        long ans = 0;

        for (int j = 0; j < k; j++) {
            long x = 0;

            for (int i = 0; i < 31; i++) {
                if (cnt[i] > 0) {
                    x |= (1L << i);
                    cnt[i]--;
                }
            }

            ans = (ans + x * x) % mod;
        }

        return (int) ans;
    }
}
