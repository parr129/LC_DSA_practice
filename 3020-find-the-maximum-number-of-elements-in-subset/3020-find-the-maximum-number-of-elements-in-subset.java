class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge((long) n, 1, Integer::sum);

        int ones = freq.getOrDefault(1L, 0);
        int ans = ones > 0 ? (ones % 2 == 1 ? ones : ones - 1) : 0;

        for (long key : freq.keySet()) {
            if (key == 1) continue;
            long cur = key;
            int len = 0;
            while (freq.containsKey(cur) && freq.get(cur) >= 2) {
                len += 2;
                cur *= cur;
            }
            if (freq.containsKey(cur)) len++;
            else len--;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}