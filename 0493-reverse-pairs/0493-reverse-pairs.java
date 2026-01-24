class Solution {
    int c = 0;

    public int reversePairs(int[] a) {
        m(a, 0, a.length - 1);
        return c;
    }

    void m(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        m(a, l, mid);
        m(a, mid + 1, r);
        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && (long) a[i] > 2L * a[j]) j++;
            c += j - (mid + 1);
        }
        int[] t = new int[r - l + 1];
        int i = l, k = 0;
        j = mid + 1;
        while (i <= mid && j <= r)
            t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= mid) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        for (i = 0; i < t.length; i++) a[l + i] = t[i];
    }
}
