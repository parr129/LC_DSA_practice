class Solution {
    public int missingMultiple(int[] a, int k) {
        int n = k;
        while (true) {
            boolean f = false;
            for (int x : a)
                if (x == n) f = true;
            if (!f) return n;
            n += k;
        }
    }
}