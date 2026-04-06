import java.util.*;

class Solution {
    public boolean makesquare(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        if (s % 4 != 0) return false;
        Arrays.sort(a);
        int[] side = new int[4];
        return dfs(a, a.length - 1, side, s / 4);
    }

    boolean dfs(int[] a, int i, int[] side, int t) {
        if (i < 0) return true;
        for (int j = 0; j < 4; j++) {
            if (side[j] + a[i] > t) continue;
            side[j] += a[i];
            if (dfs(a, i - 1, side, t)) return true;
            side[j] -= a[i];
        }
        return false;
    }
}