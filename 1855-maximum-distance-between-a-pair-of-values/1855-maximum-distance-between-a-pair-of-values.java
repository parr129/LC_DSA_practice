class Solution {
    public int maxDistance(int[] a, int[] b) {
        int i = 0, j = 0, n = a.length, m = b.length, r = 0;
        while (i < n && j < m) {
            if (a[i] > b[j]) i++;
            else {
                r = Math.max(r, j - i);
                j++;
            }
        }
        return r;
    }
}