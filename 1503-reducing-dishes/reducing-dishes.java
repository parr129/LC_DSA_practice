class Solution {
    public int maxSatisfaction(int[] a) {
        Arrays.sort(a);
        int n = a.length, s = 0, t = 0;
        for (int i = n - 1; i >= 0; i--) {
            s += a[i];
            if (s < 0) break;
            t += s;
        }
        return t;
    }
}