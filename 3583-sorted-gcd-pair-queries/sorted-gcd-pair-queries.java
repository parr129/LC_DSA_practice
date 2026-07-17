import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = 0;
            for (int j = g; j <= max; j += g) cnt += freq[j];
            exact[g] = cnt * (cnt - 1) / 2;
            for (int j = g * 2; j <= max; j += g) exact[g] -= exact[j];
        }

        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) prefix[i] = prefix[i - 1] + exact[i];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1;
            int l = 1, r = max;
            while (l < r) {
                int m = (l + r) >>> 1;
                if (prefix[m] >= k) r = m;
                else l = m + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}