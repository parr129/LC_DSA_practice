class Solution {
    public int[] sortItems(int n, int m, int[] g, List<List<Integer>> b) {
        for (int i = 0; i < n; i++) if (g[i] == -1) g[i] = m++;

        List<Integer>[] gi = new ArrayList[m], ii = new ArrayList[n];
        int[] gd = new int[m], id = new int[n];

        for (int i = 0; i < m; i++) gi[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) ii[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j : b.get(i)) {
                ii[j].add(i);
                id[i]++;
                if (g[i] != g[j]) {
                    gi[g[j]].add(g[i]);
                    gd[g[i]]++;
                }
            }
        }

        List<Integer> go = topo(gi, gd, m);
        List<Integer> io = topo(ii, id, n);

        if (go.size() == 0 || io.size() == 0) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int x : io) map.computeIfAbsent(g[x], k -> new ArrayList<>()).add(x);

        int[] res = new int[n];
        int k = 0;
        for (int x : go) {
            List<Integer> l = map.get(x);
            if (l != null) {
                for (int v : l) res[k++] = v;
            }
        }
        return res;
    }

    List<Integer> topo(List<Integer>[] g, int[] d, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (d[i] == 0) q.offer(i);

        List<Integer> r = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            r.add(u);
            for (int v : g[u]) {
                if (--d[v] == 0) q.offer(v);
            }
        }
        return r.size() == n ? r : new ArrayList<>();
    }
}