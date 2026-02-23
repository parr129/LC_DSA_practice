class Solution {
    public int countDigitOne(int n) {
        long m = 1, r = 0;
        while (m <= n) {
            long a = n / m, b = n % m;
            r += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
            m *= 10;
        }
        return (int) r;
    }
}