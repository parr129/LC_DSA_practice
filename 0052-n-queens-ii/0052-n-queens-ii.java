class Solution {
    public int totalNQueens(int n) {
        return go(0, n, new boolean[n], new boolean[2*n], new boolean[2*n]);
    }
    int go(int i, int n, boolean[] c, boolean[] d1, boolean[] d2) {
        if (i == n) return 1;
        int s = 0;
        for (int j = 0; j < n; j++) {
            int dd1 = i + j;
            int dd2 = i - j + n;
            if (!c[j] && !d1[dd1] && !d2[dd2]) {
                c[j] = d1[dd1] = d2[dd2] = true;
                s += go(i+1, n, c, d1, d2);
                c[j] = d1[dd1] = d2[dd2] = false;
            }
        }
        return s;
    }
}
