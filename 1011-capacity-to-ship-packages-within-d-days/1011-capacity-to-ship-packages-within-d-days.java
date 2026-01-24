class Solution {
    public int shipWithinDays(int[] a, int d) {
        int l = 0, r = 0;
        for (int x : a) {
            l = Math.max(l, x);
            r += x;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            int s = 0, c = 1;
            for (int x : a) {
                if (s + x > m) {
                    c++;
                    s = x;
                } else s += x;
            }
            if (c > d) l = m + 1;
            else r = m;
        }
        return l;
    }
}
