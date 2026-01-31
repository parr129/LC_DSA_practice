class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<>();
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(b[i], '.');
        back(0, n, b, r, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return r;
    }
    void back(int i, int n, char[][] b, List<List<String>> r, boolean[] c, boolean[] d1, boolean[] d2) {
        if (i == n) {
            List<String> t = new ArrayList<>();
            for (int x = 0; x < n; x++)
                t.add(new String(b[x]));
            r.add(t);
            return;
        }
        for (int j = 0; j < n; j++) {
            int dd1 = i + j;
            int dd2 = i - j + n;
            if (!c[j] && !d1[dd1] && !d2[dd2]) {
                b[i][j] = 'Q';
                c[j] = d1[dd1] = d2[dd2] = true;
                back(i+1, n, b, r, c, d1, d2);
                b[i][j] = '.';
                c[j] = d1[dd1] = d2[dd2] = false;
            }
        }
    }
}
