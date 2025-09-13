import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); // Not i + 1 because we can reuse elements
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] candidates1 = {2, 3, 6, 7};
        System.out.println("Output 1: " + sol.combinationSum(candidates1, 7)); // [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        System.out.println("Output 2: " + sol.combinationSum(candidates2, 8)); // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        int[] candidates3 = {2};
        System.out.println("Output 3: " + sol.combinationSum(candidates3, 1)); // []
    }
}

