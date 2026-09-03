class Solution {
    public boolean uniformArray(int[] a) {
        int m = Integer.MAX_VALUE;

        for (int x : a)
            if (x % 2 == 1)
                m = Math.min(m, x);

        for (int x : a)
            if (x % 2 == 0 && m != Integer.MAX_VALUE && x < m)
                return false;

        return true;
    }
}