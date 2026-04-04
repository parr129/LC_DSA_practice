class Solution {
    public int minCost(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] d = new int[m][n];
        for (int[] x : d) Arrays.fill(x, Integer.MAX_VALUE);

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[]{0,0});
        d[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int w = (g[x][y] == i + 1) ? 0 : 1;
                if (d[x][y] + w < d[nx][ny]) {
                    d[nx][ny] = d[x][y] + w;
                    if (w == 0) q.offerFirst(new int[]{nx, ny});
                    else q.offerLast(new int[]{nx, ny});
                }
            }
        }
        return d[m-1][n-1];
    }
}