class SummaryRanges {

    TreeMap<Integer, int[]> map = new TreeMap<>();

    public void addNum(int val) {
        if (map.containsKey(val)) return;

        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);

        if (l != null && map.get(l)[1] + 1 >= val &&
            h != null && val + 1 == h) {
            map.get(l)[1] = map.get(h)[1];
            map.remove(h);
        }
        else if (l != null && map.get(l)[1] + 1 >= val)
            map.get(l)[1] = Math.max(map.get(l)[1], val);
        else if (h != null && val + 1 == h) {
            int end = map.get(h)[1];
            map.remove(h);
            map.put(val, new int[]{val, end});
        }
        else
            map.put(val, new int[]{val, val});
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[0][]);
    }
}