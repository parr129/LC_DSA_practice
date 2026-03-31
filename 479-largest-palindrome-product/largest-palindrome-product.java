class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int m = (int)Math.pow(10, n) - 1;
        for (int i = m; i >= m / 10; i--) {
            long p = Long.parseLong(i + new StringBuilder(i + "").reverse().toString());
            for (long j = m; j * j >= p; j--) {
                if (p % j == 0) return (int)(p % 1337);
            }
        }
        return 0;
    }
}