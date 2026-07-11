class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            ArrayList<Integer> c = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            vis[i] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                c.add(u);
                for (int v : g[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }

            int m = c.size(), e = 0;
            for (int u : c) e += g[u].size();
            if (e / 2 == m * (m - 1) / 2) ans++;
        }

        return ans;
    }
}