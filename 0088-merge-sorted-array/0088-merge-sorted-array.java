class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both arrays
        int i = m - 1; // last element in nums1's actual data
        int j = n - 1; // last element in nums2
        int k = m + n - 1; // last index of nums1

        // Merge from the back to avoid overwriting nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 is not exhausted, copy remaining elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Test the method
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sol.merge(nums1, 3, nums2, 3);

        // Print merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: 1 2 2 3 5 6
    }
}
