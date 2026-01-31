class Solution {
    public boolean canCross(int[] s) {
        int n = s.length;
        Map<Integer, Set<Integer>> m = new HashMap<>();
        for (int x : s) m.put(x, new HashSet<>());
        m.get(s[0]).add(0);
        for (int x : s) {
            for (int k : m.get(x)) {
                for (int d = k - 1; d <= k + 1; d++) {
                    if (d > 0 && m.containsKey(x + d))
                        m.get(x + d).add(d);
                }
            }
        }
        return !m.get(s[n - 1]).isEmpty();
    }
}
