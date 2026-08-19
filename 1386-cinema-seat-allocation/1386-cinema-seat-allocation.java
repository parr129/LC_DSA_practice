import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                map.put(seat[0], map.getOrDefault(seat[0], 0) | (1 << seat[1]));
            }
        }

        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {
            boolean left = true, middle = true, right = true;

            for (int i = 2; i <= 5; i++) {
                if ((mask & (1 << i)) != 0) left = false;
            }

            for (int i = 4; i <= 7; i++) {
                if ((mask & (1 << i)) != 0) middle = false;
            }

            for (int i = 6; i <= 9; i++) {
                if ((mask & (1 << i)) != 0) right = false;
            }

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans++;
            }
        }

        return ans;
    }
}