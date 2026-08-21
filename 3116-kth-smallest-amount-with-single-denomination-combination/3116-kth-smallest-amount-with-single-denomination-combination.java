class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 1, r = (long) coins[0] * k;

        for (int c : coins) r = Math.min(r, (long) c * k);

        while (l < r) {
            long m = l + (r - l) / 2;
            long cnt = 0;
            int n = coins.length;

            for (int mask = 1; mask < (1 << n); mask++) {
                long x = 1;
                boolean ok = true;
                int bits = 0;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        bits++;
                        x = lcm(x, coins[i]);
                        if (x > m) {
                            ok = false;
                            break;
                        }
                    }
                }

                if (ok) cnt += (bits % 2 == 1 ? m / x : -m / x);
            }

            if (cnt >= k) r = m;
            else l = m + 1;
        }

        return l;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}