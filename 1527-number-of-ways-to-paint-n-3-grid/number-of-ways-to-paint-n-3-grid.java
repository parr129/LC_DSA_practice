class Solution {
    public int numOfWays(int n) {
        long a = 6, b = 6, m = 1000000007;
        for (int i = 2; i <= n; i++) {
            long x = (a * 2 + b * 2) % m;
            long y = (a * 2 + b * 3) % m;
            a = x;
            b = y;
        }
        return (int)((a + b) % m);
    }
}