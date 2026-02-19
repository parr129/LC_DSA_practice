class Solution {
    public int numberOfSubarrays(int[] n, int k) {
        return f(n, k) - f(n, k - 1);
    }
    int f(int[] n, int k) {
        int l = 0, a = 0, c = 0;
        for (int r = 0; r < n.length; r++) {
            if (n[r] % 2 == 1) c++;
            while (c > k) if (n[l++] % 2 == 1) c--;
            a += r - l + 1;
        }
        return a;
    }
}
