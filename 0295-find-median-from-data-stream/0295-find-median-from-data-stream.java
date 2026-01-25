class MedianFinder {
    PriorityQueue<Integer> a, b;
    public MedianFinder() {
        a = new PriorityQueue<>((x, y) -> y - x);
        b = new PriorityQueue<>();
    }
    public void addNum(int n) {
        a.offer(n);
        if (!a.isEmpty() && !b.isEmpty() && a.peek() > b.peek()) b.offer(a.poll());
        if (a.size() > b.size() + 1) b.offer(a.poll());
        if (b.size() > a.size()) a.offer(b.poll());
    }
    public double findMedian() {
        return a.size() > b.size() ? a.peek() : (a.peek() + b.peek()) / 2.0;
    }
}
