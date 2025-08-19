class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> value = new HashMap<>();
        int n = nums2.length;

        // Traverse nums2 from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                value.put(nums2[i], -1);
            } else {
                value.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        //Build result for nums1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = value.get(nums1[i]);
        }
        return res;
    }
}