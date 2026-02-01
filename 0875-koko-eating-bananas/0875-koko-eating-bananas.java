class Solution {
    public int minEatingSpeed(int[] a, int h) {
        int l = 1, r = 1;
        for (int x : a) r = Math.max(r, x);
        while (l < r) {
            int m = (l + r) / 2;
            long t = 0;
            for (int x : a) t += (x + m - 1) / m;
            if (t <= h) r = m;
            else l = m + 1;
        }
        return l;
    }
}
