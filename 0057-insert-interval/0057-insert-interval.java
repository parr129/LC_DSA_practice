class Solution {
    public int[][] insert(int[][] a, int[] t) {
        List<int[]> l = new ArrayList<>();
        int i = 0, n = a.length;
        while (i < n && a[i][1] < t[0]) l.add(a[i++]);
        while (i < n && a[i][0] <= t[1]) {
            t[0] = Math.min(t[0], a[i][0]);
            t[1] = Math.max(t[1], a[i][1]);
            i++;
        }
        l.add(t);
        while (i < n) l.add(a[i++]);
        return l.toArray(new int[l.size()][]);
    }
}
