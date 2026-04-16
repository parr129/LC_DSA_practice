import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length, m = 2 * n;
        int[] d = new int[m];
        Arrays.fill(d, m);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = nums[i % n];
            if (map.containsKey(x)) d[i] = i - map.get(x);
            map.put(x, i);
        }

        map.clear();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums[i % n];
            if (map.containsKey(x)) d[i] = Math.min(d[i], map.get(x) - i);
            map.put(x, i);
        }

        for (int i = 0; i < n; i++) d[i] = Math.min(d[i], d[i + n]);

        List<Integer> res = new ArrayList<>();
        for (int q : queries) res.add(d[q] >= n ? -1 : d[q]);
        return res;
    }
}