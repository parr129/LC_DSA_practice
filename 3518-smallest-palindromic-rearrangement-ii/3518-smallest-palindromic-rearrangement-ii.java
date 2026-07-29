class Solution {
    public String smallestPalindrome(String s, long k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int half = n / 2;
        boolean odd = n % 2 == 1;
        char mid = 0;
        int[] h = new int[26];
        for (int i = 0; i < 26; i++) {
            h[i] = cnt[i] / 2;
            if (cnt[i] % 2 == 1) mid = (char) ('a' + i);
        }

        if (count(h, half, k) < k) return "";

        StringBuilder sb = new StringBuilder();
        int remaining = half;
        for (int pos = 0; pos < half; pos++) {
            for (int c = 0; c < 26; c++) {
                if (h[c] == 0) continue;
                h[c]--;
                long c2 = count(h, remaining - 1, k);
                if (c2 >= k) {
                    sb.append((char) ('a' + c));
                    remaining--;
                    break;
                } else {
                    k -= c2;
                    h[c]++;
                }
            }
        }

        String halfStr = sb.toString();
        StringBuilder res = new StringBuilder(halfStr);
        if (odd) res.append(mid);
        res.append(new StringBuilder(halfStr).reverse());
        return res.toString();
    }

    // returns min(actual multinomial count of h over 'total' slots, k+1)
    private long count(int[] h, int total, long k) {
        long CAP = k + 1;
        long res = 1;
        int rem = total;
        for (int c = 0; c < 26; c++) {
            int r = h[c];
            if (r == 0) continue;
            int r2 = Math.min(r, rem - r);
            long cval = 1;
            for (int i = 1; i <= r2; i++) {
                cval = cval * (rem - r2 + i) / i;
                if (cval >= CAP) return CAP;
            }
            res *= cval;
            if (res >= CAP) return CAP;
            rem -= r;
        }
        return res;
    }
}