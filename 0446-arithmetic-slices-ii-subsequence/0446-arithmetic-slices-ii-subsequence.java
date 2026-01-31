class Solution {
    public int numberOfArithmeticSlices(int[] a) {
        int n = a.length;
        Map<Integer, Integer>[] m = new HashMap[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            m[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long) a[i] - a[j];
                if (d <= Integer.MIN_VALUE || d >= Integer.MAX_VALUE) continue;
                int di = (int) d;
                int c1 = m[j].getOrDefault(di, 0);
                int c2 = m[i].getOrDefault(di, 0);
                r += c1;
                m[i].put(di, c2 + c1 + 1);
            }
        }
        return r;
    }
}
