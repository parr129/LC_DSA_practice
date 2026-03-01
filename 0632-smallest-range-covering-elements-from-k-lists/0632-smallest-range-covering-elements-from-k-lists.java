import java.util.*;
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int l = 0, r = Integer.MAX_VALUE;
        while (true) {
            int[] cur = pq.poll();
            if (max - cur[0] < r - l) { l = cur[0]; r = max; }
            if (cur[2] + 1 == nums.get(cur[1]).size()) break;
            int next = nums.get(cur[1]).get(cur[2] + 1);
            pq.offer(new int[]{next, cur[1], cur[2] + 1});
            max = Math.max(max, next);
        }
        return new int[]{l, r};
    }
}