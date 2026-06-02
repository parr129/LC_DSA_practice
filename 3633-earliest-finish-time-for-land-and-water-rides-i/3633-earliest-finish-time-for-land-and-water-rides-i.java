class Solution {
    public int earliestFinishTime(int[] a, int[] b, int[] c, int[] d) {
        int x = 1 << 30, y = 1 << 30, ans = 1 << 30;
        for (int i = 0; i < a.length; i++) x = Math.min(x, a[i] + b[i]);
        for (int i = 0; i < c.length; i++) y = Math.min(y, c[i] + d[i]);
        for (int i = 0; i < c.length; i++) ans = Math.min(ans, Math.max(x, c[i]) + d[i]);
        for (int i = 0; i < a.length; i++) ans = Math.min(ans, Math.max(y, a[i]) + b[i]);
        return ans;
    }
}