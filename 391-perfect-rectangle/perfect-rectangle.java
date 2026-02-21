class Solution {
    public boolean isRectangleCover(int[][] r) {
        Set<String> s = new HashSet<>();
        int a = 0, x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;

        for (int[] v : r) {
            x1 = Math.min(x1, v[0]);
            y1 = Math.min(y1, v[1]);
            x2 = Math.max(x2, v[2]);
            y2 = Math.max(y2, v[3]);
            a += (v[2] - v[0]) * (v[3] - v[1]);
            String[] p = {
                v[0]+" "+v[1], v[0]+" "+v[3],
                v[2]+" "+v[1], v[2]+" "+v[3]
            };
            for (String k : p)
                if (!s.add(k)) s.remove(k);
        }

        if (s.size() != 4 ||
            !s.contains(x1+" "+y1) ||
            !s.contains(x1+" "+y2) ||
            !s.contains(x2+" "+y1) ||
            !s.contains(x2+" "+y2)) return false;

        return a == (x2 - x1) * (y2 - y1);
    }
}