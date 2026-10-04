class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] d = new boolean[n + 1][n + 1];
        d[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == '*') {
                    d[i][j] = d[i + 1][j + 1] || d[i + 1][j];
                    if (j > 0)
                        d[i][j] |= d[i + 1][j - 1];
                } else if (s.charAt(i) == '(') {
                    d[i][j] = d[i + 1][j + 1];
                } else if (j > 0) {
                    d[i][j] = d[i + 1][j - 1];
                }
            }
        }

        return d[0][0];
    }
}