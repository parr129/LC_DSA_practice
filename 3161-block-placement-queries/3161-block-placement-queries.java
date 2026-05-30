import java.util.*;

class Solution {
    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int i, int val) {
            i++;
            while (i < bit.length) {
                bit[i] = Math.max(bit[i], val);
                i += i & -i;
            }
        }

        int query(int i) {
            i++;
            int res = 0;
            while (i > 0) {
                res = Math.max(res, bit[i]);
                i -= i & -i;
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
            if (q[0] == 1) {
                set.add(q[1]);
            }
        }

        set.add(maxX + 1);

        Fenwick bit = new Fenwick(maxX + 5);

        Integer prev = null;
        for (int x : set) {
            if (prev != null) {
                bit.update(x, x - prev);
            }
            prev = x;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 1) {
                int x = q[1];
                int l = set.lower(x);
                int r = set.higher(x);
                bit.update(r, r - l);
                set.remove(x);
            } else {
                int x = q[1];
                int sz = q[2];
                int p = set.floor(x);
                int best = Math.max(bit.query(p), x - p);
                ans.add(best >= sz);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}