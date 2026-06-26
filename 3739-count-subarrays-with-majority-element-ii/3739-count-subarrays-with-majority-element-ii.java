import java.util.*;

class Solution {
    static class Fenwick {
        int n;
        long[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int i, long v) {
            while (i <= n) {
                bit[i] += v;
                i += i & -i;
            }
        }

        long sum(int i) {
            long res = 0;
            while (i > 0) {
                res += bit[i];
                i -= i & -i;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == k ? 1 : -1);
        }

        int[] vals = pref.clone();
        Arrays.sort(vals);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int v : vals) {
            if (!map.containsKey(v)) {
                map.put(v, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx);
        long ans = 0;

        for (int v : pref) {
            int id = map.get(v);
            ans += bit.sum(id - 1);
            bit.add(id, 1);
        }

        return ans;
    }
}