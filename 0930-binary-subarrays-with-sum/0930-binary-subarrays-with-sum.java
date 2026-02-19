class Solution {
    public int numSubarraysWithSum(int[] n, int g) {
        return f(n, g) - f(n, g - 1);
    }
    int f(int[] n, int g) {
        if (g < 0) return 0;
        int l = 0, s = 0, a = 0;
        for (int r = 0; r < n.length; r++) {
            s += n[r];
            while (s > g) s -= n[l++];
            a += r - l + 1;
        }
        return a;
    }
}
