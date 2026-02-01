class Solution {
    public int lengthOfLIS(int[] a) {
        int[] t = new int[a.length];
        int m = 0;
        for (int x : a) {
            int i = Arrays.binarySearch(t, 0, m, x);
            if (i < 0) i = -(i + 1);
            t[i] = x;
            if (i == m) m++;
        }
        return m;
    }
}
