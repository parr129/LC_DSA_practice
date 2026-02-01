class Solution {
    public int[] findOrder(int n, int[][] p) {
        List<List<Integer>> g = new ArrayList<>();
        int[] in = new int[n];
        for (int i = 0; i < n; ++i) g.add(new ArrayList<>());
        for (int[] x : p) {
            g.get(x[1]).add(x[0]);
            in[x[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) if (in[i] == 0) q.add(i);
        int[] r = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            r[idx++] = u;
            for (int v : g.get(u)) if (--in[v] == 0) q.add(v);
        }
        return idx == n ? r : new int[0];
    }
}
