class Solution {
    public int coinChange(int[] c, int amt) {
        int[] d = new int[amt + 1];
        Arrays.fill(d, amt + 1);
        d[0] = 0;
        for (int i = 1; i <= amt; i++)
            for (int x : c)
                if (i >= x)
                    d[i] = Math.min(d[i], d[i - x] + 1);
        return d[amt] > amt ? -1 : d[amt];
    }
}
