class Solution {
    public boolean uniformArray(int[] nums1) {
        for (int n : nums1) {
            if (n % 2 != 0) {
                for (int m : nums1) {
                    if (m % 2 == 0) return true;
                }
            }
        }
        return true;
    }
}