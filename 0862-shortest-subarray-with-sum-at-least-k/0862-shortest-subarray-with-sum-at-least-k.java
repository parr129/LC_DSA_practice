import java.util.*;
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = n + 1;
        long sum = 0;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && pre[i] - pre[dq.peekFirst()] >= k)
                res = Math.min(res, i - dq.pollFirst());
            while (!dq.isEmpty() && pre[i] <= pre[dq.peekLast()]) dq.pollLast();
            dq.offerLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}