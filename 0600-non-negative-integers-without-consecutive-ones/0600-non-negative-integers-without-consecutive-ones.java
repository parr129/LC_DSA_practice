class Solution {
    public int findIntegers(int n) {
        int[] f = new int[32];
        f[0] = 1; f[1] = 2;
        for (int i = 2; i < 32; i++) f[i] = f[i-1] + f[i-2];
        int r = 0, p = 0;
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                r += f[i];
                if (p == 1) return r;
                p = 1;
            } else p = 0;
        }
        return r + 1;
    }
}