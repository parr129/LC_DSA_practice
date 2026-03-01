import java.util.*;
class Solution {
    public int findMaxValueOfEquation(int[][] p, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int[] a : p) {
            while (!dq.isEmpty() && a[0] - dq.peekFirst()[1] > k) dq.pollFirst();
            if (!dq.isEmpty()) ans = Math.max(ans, a[0] + a[1] + dq.peekFirst()[0]);
            int val = a[1] - a[0];
            while (!dq.isEmpty() && dq.peekLast()[0] <= val) dq.pollLast();
            dq.offerLast(new int[]{val, a[0]});
        }
        return ans;
    }
}