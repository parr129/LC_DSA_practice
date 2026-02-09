import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int x : a) {
            q.offer(x);
            if (q.size() > k) q.poll();
        }
    }

    public int add(int v) {
        q.offer(v);
        if (q.size() > k) q.poll();
        return q.peek();
    }
}
