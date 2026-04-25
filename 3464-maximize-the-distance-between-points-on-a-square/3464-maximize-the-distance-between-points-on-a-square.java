import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) a[i] = x;
            else if (x == side) a[i] = side + y;
            else if (y == side) a[i] = 3L * side - x;
            else a[i] = 4L * side - y;
        }
        Arrays.sort(a);

        long[] b = new long[2 * n];
        long P = 4L * side;
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            b[i + n] = a[i] + P;
        }

        int lo = 1, hi = side, ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (ok(b, n, k, mid, P)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    boolean ok(long[] b, int n, int k, int d, long P) {
        for (int i = 0; i < n; i++) {
            int cnt = 1, idx = i;
            for (int t = 1; t < k; t++) {
                idx = lower(b, idx + 1, i + n, b[idx] + d);
                if (idx == -1) break;
                cnt++;
            }
            if (cnt == k && b[idx] - b[i] <= P - d) return true;
        }
        return false;
    }

    int lower(long[] b, int l, int r, long val) {
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (b[m] >= val) {
                ans = m;
                r = m - 1;
            } else l = m + 1;
        }
        return ans;
    }
}