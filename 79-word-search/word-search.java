class Solution {
    public boolean exist(char[][] b, String w) {
        int m = b.length, n = b[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(b, w, i, j, 0)) return true;
        return false;
    }
    boolean dfs(char[][] b, String w, int i, int j, int k) {
        if (k == w.length()) return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(k)) return false;
        char t = b[i][j];
        b[i][j] = '#';
        if (dfs(b, w, i+1, j, k+1) || dfs(b, w, i-1, j, k+1) || dfs(b, w, i, j+1, k+1) || dfs(b, w, i, j-1, k+1)) return true;
        b[i][j] = t;
        return false;
    }
}
