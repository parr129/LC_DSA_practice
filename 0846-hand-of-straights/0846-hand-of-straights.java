class Solution {
    public boolean isNStraightHand(int[] h, int g) {
        if (h.length % g != 0) return false;
        java.util.TreeMap<Integer,Integer> m = new java.util.TreeMap<>();
        for (int x : h) m.put(x, m.getOrDefault(x, 0) + 1);
        for (int x : m.keySet()) {
            int c = m.get(x);
            if (c > 0) {
                for (int i = 0; i < g; i++) {
                    int k = x + i;
                    if (m.getOrDefault(k, 0) < c) return false;
                    m.put(k, m.get(k) - c);
                }
            }
        }
        return true;
    }
}
