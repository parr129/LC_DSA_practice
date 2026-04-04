class Solution {
    public int maxCandies(int[] s, int[] c, int[][] k, int[][] b, int[] ib) {
        int n = s.length, r = 0;
        boolean[] v = new boolean[n], h = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int x : ib) {
            h[x] = true;
            if (s[x] == 1) q.offer(x);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (v[u]) continue;
            v[u] = true;
            r += c[u];

            for (int x : k[u]) {
                s[x] = 1;
                if (h[x] && !v[x]) q.offer(x);
            }

            for (int x : b[u]) {
                h[x] = true;
                if (s[x] == 1 && !v[x]) q.offer(x);
            }
        }
        return r;
    }
}