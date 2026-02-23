class Solution {
    public java.util.List<Integer> getRow(int r) {
        java.util.List<Integer> a = new java.util.ArrayList<>();
        for (int i = 0; i <= r; i++) {
            a.add(1);
            for (int j = i - 1; j > 0; j--)
                a.set(j, a.get(j) + a.get(j - 1));
        }
        return a;
    }
}