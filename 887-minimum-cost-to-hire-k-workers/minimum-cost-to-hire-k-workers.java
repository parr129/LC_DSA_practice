import java.util.*;
class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        int n = q.length;
        double[][] a = new double[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = (double) w[i] / q[i];
            a[i][1] = q[i];
        }
        Arrays.sort(a, (x, y) -> Double.compare(x[0], y[0]));
        PriorityQueue<Integer> h = new PriorityQueue<>((x, y) -> y - x);
        double sum = 0, r = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i][1];
            h.add((int) a[i][1]);
            if (h.size() > k) sum -= h.remove();
            if (h.size() == k) r = Math.min(r, sum * a[i][0]);
        }
        return r;
    }
}