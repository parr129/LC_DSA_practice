class Solution {
    List<List<Integer>> r = new ArrayList<>();
    List<Integer>[] g;
    int[] d, l;
    int t = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> e) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (List<Integer> x : e) {
            int u = x.get(0), v = x.get(1);
            g[u].add(v);
            g[v].add(u);
        }
        d = new int[n];
        l = new int[n];
        Arrays.fill(d, -1);
        dfs(0, -1);
        return r;
    }

    void dfs(int u, int p) {
        d[u] = l[u] = t++;
        for (int v : g[u]) {
            if (v == p) continue;
            if (d[v] == -1) {
                dfs(v, u);
                l[u] = Math.min(l[u], l[v]);
                if (l[v] > d[u]) r.add(Arrays.asList(u, v));
            } else l[u] = Math.min(l[u], d[v]);
        }
    }
}