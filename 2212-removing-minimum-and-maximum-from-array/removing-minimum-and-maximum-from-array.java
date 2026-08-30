import java.util.*;

public class Main {
    static void solution() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = s.nextInt();

            int mn = 0, mx = 0;

            for (int i = 1; i < n; i++) {
                if (a[i] < a[mn]) mn = i;
                if (a[i] > a[mx]) mx = i;
            }

            if (mn > mx) {
                int x = mn;
                mn = mx;
                mx = x;
            }

            int ans = Math.min(mx + 1, n - mn);
            ans = Math.min(ans, mn + 1 + n - mx);

            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        solution();
    }
}class Solution {
    public int minimumDeletions(int[] a) {
        int n = a.length;
        int mn = 0, mx = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[mn]) mn = i;
            if (a[i] > a[mx]) mx = i;
        }

        if (mn > mx) {
            int x = mn;
            mn = mx;
            mx = x;
        }

        int x = mx + 1;
        int y = n - mn;
        int z = mn + 1 + n - mx;

        return Math.min(x, Math.min(y, z));
    }
}