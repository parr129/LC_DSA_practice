class Solution {
    private char[] s;
    private long[][][][][] cntMemo;
    private long[][][][][] sumMemo;
    private boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;
        s = Long.toString(x).toCharArray();
        int n = s.length;

        cntMemo = new long[n + 1][11][11][2][2];
        sumMemo = new long[n + 1][11][11][2][2];
        vis = new boolean[n + 1][11][11][2][2];

        return dfs(0, 10, 10, 0, 1)[1];
    }

    private long[] dfs(int pos, int last1, int last2, int started, int tight) {
        if (pos == s.length) {
            return new long[]{1L, 0L};
        }

        if (tight == 0 && vis[pos][last1][last2][started][0]) {
            return new long[]{
                cntMemo[pos][last1][last2][started][0],
                sumMemo[pos][last1][last2][started][0]
            };
        }

        int up = tight == 1 ? s[pos] - '0' : 9;
        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= up; d++) {
            int ntight = (tight == 1 && d == up) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 10, 10, 0, ntight);
                totalCnt += nxt[0];
                totalSum += nxt[1];
            } else {
                int nstarted = 1;
                int add = 0;

                if (last2 != 10) {
                    if ((last1 > last2 && last1 > d) || (last1 < last2 && last1 < d)) {
                        add = 1;
                    }
                }

                int nlast2 = last1;
                int nlast1 = d;

                if (last1 == 10) {
                    nlast2 = 10;
                }

                long[] nxt = dfs(pos + 1, nlast1, nlast2, nstarted, ntight);
                totalCnt += nxt[0];
                totalSum += nxt[1] + nxt[0] * add;
            }
        }

        if (tight == 0) {
            vis[pos][last1][last2][started][0] = true;
            cntMemo[pos][last1][last2][started][0] = totalCnt;
            sumMemo[pos][last1][last2][started][0] = totalSum;
        }

        return new long[]{totalCnt, totalSum};
    }
}