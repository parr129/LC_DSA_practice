class Solution {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] vis = new boolean[n + 1];
        dfs(n, 1, vis);
        return count;
    }

    void dfs(int n, int pos, boolean[] vis) {
        if (pos > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && (i % pos == 0 || pos % i == 0)) {
                vis[i] = true;
                dfs(n, pos + 1, vis);
                vis[i] = false;
            }
        }
    }
}