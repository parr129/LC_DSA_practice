import java.util.*;
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length, res = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i] + (dq.isEmpty() ? 0 : dp[dq.peekFirst()]);
            res = Math.max(res, dp[i]);
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
            if (dp[i] > 0) dq.offerLast(i);
            if (!dq.isEmpty() && i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return res;
    }
}