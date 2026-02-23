class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || p[j + 1][i - 1])) {
                    p[j][i] = true;
                    d[i] = j == 0 ? 0 : Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n - 1];
    }
}