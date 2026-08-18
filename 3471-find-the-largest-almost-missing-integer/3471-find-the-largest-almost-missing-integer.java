class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        if (k == 1) {
            int max = -1;
            for (int num : nums) {
                if (counts.get(num) == 1) {
                    max = Math.max(max, num);
                }
            }
            return max;
        }
        
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        
        int first = nums[0], last = nums[n - 1];
        int ans = -1;
        if (counts.get(first) == 1) ans = Math.max(ans, first);
        if (counts.get(last) == 1) ans = Math.max(ans, last);
        return ans;
    }
}