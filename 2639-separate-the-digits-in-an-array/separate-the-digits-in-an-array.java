class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int n : nums) {
            for (char c : String.valueOf(n).toCharArray()) {
                list.add(c - '0');
            }
        }

        int[] ans = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}