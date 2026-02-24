class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m + 1][n + 1];
        d[0][0] = true;
        for (int j = 2; j <= n; j++)
            if (p.charAt(j - 1) == '*') d[0][j] = d[0][j - 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = s.charAt(i - 1), b = p.charAt(j - 1);
                if (b == '.' || a == b) d[i][j] = d[i - 1][j - 1];
                else if (b == '*') {
                    d[i][j] = d[i][j - 2];
                    char c = p.charAt(j - 2);
                    if (c == '.' || c == a) d[i][j] |= d[i - 1][j];
                }
            }
        }
        return d[m][n];
    }
}