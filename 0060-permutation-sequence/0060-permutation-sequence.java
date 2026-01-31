class Solution {
    public String getPermutation(int n, int k) {
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) f[i] = f[i-1] * i;
        StringBuilder r = new StringBuilder();
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) a.add(i);
        k--;
        for (int i = n; i >= 1; i--) {
            int idx = k / f[i-1];
            r.append(a.get(idx));
            a.remove(idx);
            k %= f[i-1];
        }
        return r.toString();
    }
}
