import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> g = new ArrayList<>();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] a : p) {
            g.get(a[1]).add(a[0]);
            in[a[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (in[i] == 0) q.add(i);
        int c = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            c++;
            for (int x : g.get(t)) {
                if (--in[x] == 0) q.add(x);
            }
        }
        return c == n;
    }
}
