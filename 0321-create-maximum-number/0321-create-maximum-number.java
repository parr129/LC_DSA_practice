class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] a = maxArray(nums1, i);
            int[] b = maxArray(nums2, k - i);
            int[] cand = merge(a, b);
            if (greater(cand, 0, res, 0)) res = cand;
        }
        return res;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1, remain = nums.length;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remain > k - top - 1) top--;
            if (top + 1 < k) stack[++top] = num;
            remain--;
        }
        return stack;
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, r = 0;
        while (i < a.length || j < b.length)
            res[r++] = greater(a, i, b, j) ? a[i++] : b[j++];
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) { i++; j++; }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}