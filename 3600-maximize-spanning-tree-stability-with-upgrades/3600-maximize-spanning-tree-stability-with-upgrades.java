import java.util.*;

class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parent[pa] = pb;
        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 0;
        for (int[] e : edges) right = Math.max(right, e[2] * 2);

        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return ans;
    }

    boolean check(int n, int[][] edges, int k, int x) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int used = 0, upgrades = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < x) return false;
                if (!union(e[0], e[1])) return false;
                used++;
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int[] e : edges) {
            if (e[3] == 0) list.add(e);
        }

        list.sort((a, b) -> b[2] - a[2]);

        for (int[] e : list) {
            if (used == n - 1) break;
            if (e[2] >= x) {
                if (union(e[0], e[1])) used++;
            } else if (e[2] * 2 >= x && upgrades < k) {
                if (union(e[0], e[1])) {
                    used++;
                    upgrades++;
                }
            }
        }

        return used == n - 1;
    }
}