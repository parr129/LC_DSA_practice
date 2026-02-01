class Solution {
    public int orangesRotting(int[][] g) {
        int m = g.length, n = g[0].length, f = 0, d = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (g[i][j] == 2) q.add(new int[]{i, j});
                else if (g[i][j] == 1) f++;
        if (f == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean ok = false;
            for (int i = 0; i < sz; ++i) {
                int[] p = q.poll();
                for (int[] v : dirs) {
                    int x = p[0]+v[0], y = p[1]+v[1];
                    if (x>=0&&y>=0&&x<m&&y<n&&g[x][y]==1) {
                        g[x][y]=2;
                        f--;
                        q.add(new int[]{x,y});
                        ok = true;
                    }
                }
            }
            if (ok) d++;
        }
        return f == 0 ? d : -1;
    }
}
