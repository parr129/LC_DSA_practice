import java.util.*;

class Solution {
    long[][] dp;
    List<Integer> r;
    int[][] f;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        r = robot;
        f = factory;
        dp = new long[robot.size()][factory.length];
        return dfs(0, 0);
    }

    long dfs(int i, int j) {
        if (i == r.size()) return 0;
        if (j == f.length) return (long)1e15;
        if (dp[i][j] != 0) return dp[i][j];
        long res = dfs(i, j + 1), sum = 0;
        for (int k = 0; k < f[j][1] && i + k < r.size(); k++) {
            sum += Math.abs(r.get(i + k) - f[j][0]);
            res = Math.min(res, sum + dfs(i + k + 1, j + 1));
        }
        return dp[i][j] = res;
    }
}