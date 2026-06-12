class Solution {
    static final int MOD = 1_000_000_007;
    List<Integer>[] g;
    int[][] up;
    int[] dep, pow;
    int LOG;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        LOG = 18;
        while ((1 << LOG) <= n) LOG++;

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        up = new int[n + 1][LOG];
        dep = new int[n + 1];
        dfs(1, 0);

        for (int j = 1; j < LOG; j++)
            for (int i = 1; i <= n; i++)
                up[i][j] = up[up[i][j - 1]][j - 1];

        pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++)
            pow[i] = (int) ((long) pow[i - 1] * 2 % MOD);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            int l = lca(u, v);
            int d = dep[u] + dep[v] - 2 * dep[l];
            ans[i] = d == 0 ? 0 : pow[d - 1];
        }
        return ans;
    }

    void dfs(int u, int p) {
        up[u][0] = p;
        for (int v : g[u]) {
            if (v == p) continue;
            dep[v] = dep[u] + 1;
            dfs(v, u);
        }
    }

    int lca(int a, int b) {
        if (dep[a] < dep[b]) {
            int t = a;
            a = b;
            b = t;
        }

        int d = dep[a] - dep[b];
        for (int i = 0; i < LOG; i++)
            if ((d & (1 << i)) != 0)
                a = up[a][i];

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[a][i] != up[b][i]) {
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }
}