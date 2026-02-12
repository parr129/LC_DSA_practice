import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> r = new PriorityQueue<>();

    public void addNum(int n) {
        l.add(n);
        r.add(l.poll());
        if (r.size() > l.size())
            l.add(r.poll());
    }

    public double findMedian() {
        if (l.size() > r.size())
            return l.peek();
        return (l.peek() + r.peek()) / 2.0;
    }
}
