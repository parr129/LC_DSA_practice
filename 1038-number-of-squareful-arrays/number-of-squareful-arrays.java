import java.util.*;

class Solution {
    int res = 0;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis, -1, 0);
        return res;
    }

    void dfs(int[] nums, boolean[] vis, int prev, int cnt) {
        if (cnt == nums.length) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;
            if (prev != -1) {
                int s = prev + nums[i];
                int r = (int)Math.sqrt(s);
                if (r * r != s) continue;
            }
            vis[i] = true;
            dfs(nums, vis, nums[i], cnt + 1);
            vis[i] = false;
        }
    }
}