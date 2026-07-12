class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] a = arr.clone();
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for (int x : a)
            if (!map.containsKey(x))
                map.put(x, r++);
        for (int i = 0; i < arr.length; i++)
            arr[i] = map.get(arr[i]);
        return arr;
    }
}