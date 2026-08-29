import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] a, int k) {
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) b[i] = i;
        Arrays.sort(b, (i, j) -> a[i] - a[j]);

        int[] r = new int[n];
        int s = 0;

        while (s < n) {
            int e = s;
            while (e + 1 < n && a[b[e + 1]] - a[b[e]] <= k) e++;

            int[] p = new int[e - s + 1];
            for (int i = s; i <= e; i++) p[i - s] = b[i];
            Arrays.sort(p);

            for (int i = 0; i < p.length; i++) r[p[i]] = a[b[s + i]];
            s = e + 1;
        }
        return r;
    }
}