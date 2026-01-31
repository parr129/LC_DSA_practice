class Solution {
    public int maxEnvelopes(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        int[] b = new int[a.length];
        int c = 0;
        for (int[] e : a) {
            int v = e[1];
            int i = Arrays.binarySearch(b, 0, c, v);
            if (i < 0) i = -(i + 1);
            b[i] = v;
            if (i == c) c++;
        }
        return c;
    }
}
