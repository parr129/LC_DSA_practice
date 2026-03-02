class Solution {
    double t = 0, v = 0;
    int[] b;
    int n;
    double[] f = new double[50];

    public double getProbability(int[] a) {
        b = a;
        int s = 0;
        for (int x : a) s += x;
        n = s / 2;
        f[0] = 1;
        for (int i = 1; i < 50; i++) f[i] = f[i - 1] * i;
        dfs(0, 0, 0, 0, 1);
        return v / t;
    }

    void dfs(int i, int c1, int c2, int d, double w) {
        if (i == b.length) {
            if (c1 == n && c2 == n) {
                t += w;
                if (d == 0) v += w;
            }
            return;
        }
        for (int x = 0; x <= b[i]; x++) {
            int y = b[i] - x;
            int nc1 = c1 + x, nc2 = c2 + y;
            if (nc1 > n || nc2 > n) continue;
            int nd = d;
            if (x > 0) nd++;
            if (y > 0) nd--;
            double nw = w / (f[x] * f[y]);
            dfs(i + 1, nc1, nc2, nd, nw);
        }
    }
}
